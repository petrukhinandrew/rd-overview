package org.example.demo

import com.jetbrains.rd.framework.SerializationCtx
import com.jetbrains.rd.framework.Serializers
import com.jetbrains.rd.framework.createAbstractBuffer
import org.example.generated.models.ChildStruct
import org.example.generated.models.ChildStruct.Companion.write
import org.example.generated.models.DemoModel

object RawSerialization {

    private val ctx = createContext()

    private fun createContext(): SerializationCtx {
        val serializers = Serializers()
        serializers.registerSerializersOwnerOnce(DemoModel)
        return SerializationCtx(serializers)
    }

    fun ChildStruct.bytes(): ByteArray {
        val buf = createAbstractBuffer()
        write(ctx, buf, this)
        return buf.getArray()
    }

    fun ByteArray.toChildStruct(): ChildStruct {
        val buf = createAbstractBuffer(this)
        return ChildStruct.read(ctx, buf)
    }
}