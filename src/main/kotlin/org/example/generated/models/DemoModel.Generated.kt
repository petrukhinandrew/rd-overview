@file:Suppress("EXPERIMENTAL_API_USAGE","EXPERIMENTAL_UNSIGNED_LITERALS","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName","UnnecessaryVariable","SpellCheckingInspection")
package org.example.generated.models

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.time.Duration
import kotlin.reflect.KClass
import kotlin.jvm.JvmStatic



/**
 * #### Generated from [DemoModel.kt:5]
 */
class DemoModel private constructor(
    private val _makeChildStruct: RdCall<SimpleRequest, ChildStruct>,
    private val _callResultReceived: RdSignal<ParentStruct?>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(ChildStruct)
            serializers.register(AnotherChildStruct)
            serializers.register(SimpleRequest)
            serializers.register(ParentStruct_Unknown)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): DemoModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.demoModel or revise the extension scope instead", ReplaceWith("protocol.demoModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): DemoModel  {
            DemoRoot.register(protocol.serializers)
            
            return DemoModel()
        }
        
        private val __ParentStructNullableSerializer = AbstractPolymorphic(ParentStruct).nullable()
        
        const val serializationHash = -5349317827746171709L
        
    }
    override val serializersOwner: ISerializersOwner get() = DemoModel
    override val serializationHash: Long get() = DemoModel.serializationHash
    
    //fields
    val makeChildStruct: RdCall<SimpleRequest, ChildStruct> get() = _makeChildStruct
    val callResultReceived: ISignal<ParentStruct?> get() = _callResultReceived
    //methods
    //initializer
    init {
        bindableChildren.add("makeChildStruct" to _makeChildStruct)
        bindableChildren.add("callResultReceived" to _callResultReceived)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdCall<SimpleRequest, ChildStruct>(SimpleRequest, ChildStruct),
        RdSignal<ParentStruct?>(__ParentStructNullableSerializer)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("DemoModel (")
        printer.indent {
            print("makeChildStruct = "); _makeChildStruct.print(printer); println()
            print("callResultReceived = "); _callResultReceived.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): DemoModel   {
        return DemoModel(
            _makeChildStruct.deepClonePolymorphic(),
            _callResultReceived.deepClonePolymorphic()
        )
    }
    //contexts
}
val IProtocol.demoModel get() = getOrCreateExtension(DemoModel::class) { @Suppress("DEPRECATION") DemoModel.create(lifetime, this) }



/**
 * #### Generated from [DemoModel.kt:12]
 */
class AnotherChildStruct (
    val anotherChildField: String,
    parentField: String
) : ParentStruct (
    parentField
) {
    //companion
    
    companion object : IMarshaller<AnotherChildStruct> {
        override val _type: KClass<AnotherChildStruct> = AnotherChildStruct::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): AnotherChildStruct  {
            val parentField = buffer.readString()
            val anotherChildField = buffer.readString()
            return AnotherChildStruct(anotherChildField, parentField)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: AnotherChildStruct)  {
            buffer.writeString(value.parentField)
            buffer.writeString(value.anotherChildField)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as AnotherChildStruct
        
        if (anotherChildField != other.anotherChildField) return false
        if (parentField != other.parentField) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + anotherChildField.hashCode()
        __r = __r*31 + parentField.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("AnotherChildStruct (")
        printer.indent {
            print("anotherChildField = "); anotherChildField.print(printer); println()
            print("parentField = "); parentField.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
}


/**
 * #### Generated from [DemoModel.kt:9]
 */
class ChildStruct (
    val childField: String,
    parentField: String
) : ParentStruct (
    parentField
) {
    //companion
    
    companion object : IMarshaller<ChildStruct> {
        override val _type: KClass<ChildStruct> = ChildStruct::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ChildStruct  {
            val parentField = buffer.readString()
            val childField = buffer.readString()
            return ChildStruct(childField, parentField)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ChildStruct)  {
            buffer.writeString(value.parentField)
            buffer.writeString(value.childField)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as ChildStruct
        
        if (childField != other.childField) return false
        if (parentField != other.parentField) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + childField.hashCode()
        __r = __r*31 + parentField.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ChildStruct (")
        printer.indent {
            print("childField = "); childField.print(printer); println()
            print("parentField = "); parentField.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
}


/**
 * #### Generated from [DemoModel.kt:6]
 */
abstract class ParentStruct (
    val parentField: String
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<ParentStruct> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): ParentStruct  {
            val objectStartPosition = buffer.position
            val parentField = buffer.readString()
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return ParentStruct_Unknown(parentField, unknownId, unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    //deepClone
    //contexts
}


class ParentStruct_Unknown (
    parentField: String,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : ParentStruct (
    parentField
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<ParentStruct_Unknown> {
        override val _type: KClass<ParentStruct_Unknown> = ParentStruct_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ParentStruct_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ParentStruct_Unknown)  {
            buffer.writeString(value.parentField)
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as ParentStruct_Unknown
        
        if (parentField != other.parentField) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + parentField.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ParentStruct_Unknown (")
        printer.indent {
            print("parentField = "); parentField.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
}


/**
 * #### Generated from [DemoModel.kt:15]
 */
data class SimpleRequest (
    val value: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<SimpleRequest> {
        override val _type: KClass<SimpleRequest> = SimpleRequest::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): SimpleRequest  {
            val value = buffer.readInt()
            return SimpleRequest(value)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: SimpleRequest)  {
            buffer.writeInt(value.value)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as SimpleRequest
        
        if (value != other.value) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + value.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("SimpleRequest (")
        printer.indent {
            print("value = "); value.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
}
