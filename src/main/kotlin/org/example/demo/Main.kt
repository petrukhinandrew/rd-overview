package org.example.demo

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.bind
import com.jetbrains.rd.framework.impl.RpcTimeouts
import com.jetbrains.rd.util.catch
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rd.util.lifetime.LifetimeDefinition
import com.jetbrains.rd.util.lifetime.isAlive
import com.jetbrains.rd.util.reactive.IScheduler
import com.jetbrains.rd.util.threading.SingleThreadScheduler
import org.example.demo.RawSerialization.bytes
import org.example.demo.RawSerialization.toChildStruct
import org.example.generated.models.*
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

val ldef = LifetimeDefinition()

fun pumpCurrentThread(lifetime: Lifetime, initializationAction: (IScheduler) -> Unit) {
    val actions = ConcurrentLinkedQueue<() -> Unit>()
    val currentThread = Thread.currentThread()
    val scheduler = object : IScheduler {
        override val isActive: Boolean
            get() = currentThread == Thread.currentThread()

        override fun flush() {
            while (true) {
                val action = actions.poll() ?: return
                if (lifetime.isAlive)
                    catch { action() }
            }
        }

        override fun queue(action: () -> Unit) {
            if (lifetime.isAlive)
                actions.add(action)
        }
    }

    initializationAction(scheduler)

    j@ while (lifetime.isAlive) {
        val action = actions.poll()
        if (action == null) {
            Thread.yield()
            continue@j
        }
        catch { action() }
    }
}

fun main(args: Array<String>) {
    thread {
        Thread.sleep(3000)
        ldef.terminate()
    }

    val name = "rd-example"
    val lifetime = ldef.lifetime
//    useSingleThreadScheduler(lifetime, args, name)
    useBlockingScheduler(lifetime, args, name)

}

private fun useSingleThreadScheduler(lifetime: Lifetime, args: Array<String>, name: String) {
    thread {
        val scheduler = SingleThreadScheduler(lifetime, "scheduler")
        scheduler.invokeOrQueue {
            rdRoutine(scheduler, lifetime, args, name)
        }
    }
}

private fun useBlockingScheduler(
    lifetime: Lifetime,
    args: Array<String>,
    name: String
) {
    pumpCurrentThread(lifetime) { scheduler ->
        rdRoutine(scheduler, lifetime, args, name)
    }
}

private fun rdRoutine(scheduler: IScheduler, lifetime: Lifetime, args: Array<String>, name: String) {
    val idKind: IdKind
    val wire: IWire

    if (args.isEmpty()) {

        val port = 8083

        ProcessBuilder(
            "${System.getProperty("java.home")}/bin/java",
            "-cp",
            System.getProperty("java.class.path"),
            "org.example.demo.MainKt",
            port.toString()
        ).inheritIO().start()

        wire = SocketWire.Server(lifetime, scheduler, port, name, true)

        idKind = IdKind.Server
    } else {
        val port = args[0].toInt()

        wire = SocketWire.Client(lifetime, scheduler, port, name)
        idKind = IdKind.Client
    }
    val protocol = Protocol(
        "rd-protocol", Serializers(), Identities(idKind), scheduler, wire, lifetime
    )

    if (idKind == IdKind.Server) {

        val firstRequest = SimpleRequest(123)
        val firstResponse = protocol.demoModel.makeChildStruct.sync(firstRequest, RpcTimeouts.longRunning)
        println("Server: call(123) = $firstResponse")
        protocol.demoModel.callResultReceived.fire(firstResponse)

        val secondRequest = SimpleRequest(456)
        val secondResponse = protocol.demoModel.makeChildStruct.sync(secondRequest, RpcTimeouts.longRunning)
        println("Server: call(456) = $secondResponse")

        protocol.demoModel.makeChildStruct.start(
            ldef.lifetime,
            SimpleRequest(0)
        ).result.advise(ldef.lifetime) { result ->
            val signalValue = if (result is RdTaskResult.Success)
                AnotherChildStruct(
                    secondResponse.parentField,
                    secondResponse.childField
                )
            else null
            println("Server: call(0) = $signalValue")

            protocol.demoModel.callResultReceived.fire(signalValue)
        }
        val reactiveClass = protocol.complexModel.getOrCreateExtension("reactiveClass") {
            ReactiveClass()
        }

        reactiveClass.values.adviseAddRemove(lifetime) { addRemove, i, s ->
            println("$addRemove $i $s")
        }


    } else {
        protocol.demoModel.makeChildStruct.set { request ->
            println("Client: call(${request.value}) received")
            when (request.value) {
                123 -> ChildStruct("parent", "child")
                456 -> ChildStruct("another", "version")
                else -> throw IllegalArgumentException()
            }
        }

        protocol.demoModel.callResultReceived.advise(ldef.lifetime) { notification ->
            println("Client: signal $notification received")
            if (notification is ChildStruct) {
                println("Client: call result is ChildStruct, comparison: ${notification.bytes().toChildStruct() == notification}")
            }
        }

        protocol.complexModel.getOrCreateExtension("reactiveClass") {
            ReactiveClass()
        }.apply {
            values.add("first")
            values.add("second")
            values.add("third")
            values.remove("second")
            values.removeAt(1)
        }


    }
}