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
 * #### Generated from [ComplexModel.kt:5]
 */
class ComplexModel private constructor(
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(ReactiveClass)
            serializers.register(ReactiveClass_Unknown)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): ComplexModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.complexModel or revise the extension scope instead", ReplaceWith("protocol.complexModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): ComplexModel  {
            DemoRoot.register(protocol.serializers)
            
            return ComplexModel()
        }
        
        
        const val serializationHash = -119442132346258741L
        
    }
    override val serializersOwner: ISerializersOwner get() = ComplexModel
    override val serializationHash: Long get() = ComplexModel.serializationHash
    
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ComplexModel (")
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ComplexModel   {
        return ComplexModel(
        )
    }
    //contexts
}
val IProtocol.complexModel get() = getOrCreateExtension(ComplexModel::class) { @Suppress("DEPRECATION") ComplexModel.create(lifetime, this) }



/**
 * #### Generated from [ComplexModel.kt:6]
 */
open class ReactiveClass protected constructor(
    protected val _values: RdList<String>
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<ReactiveClass>, IAbstractDeclaration<ReactiveClass> {
        override val _type: KClass<ReactiveClass> = ReactiveClass::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ReactiveClass  {
            val _id = RdId.read(buffer)
            val _values = RdList.read(ctx, buffer, FrameworkMarshallers.String)
            return ReactiveClass(_values).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ReactiveClass)  {
            value.rdid.write(buffer)
            RdList.write(ctx, buffer, value._values)
        }
        
        
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): ReactiveClass  {
            val objectStartPosition = buffer.position
            val _id = RdId.read(buffer)
            val _values = RdList.read(ctx, buffer, FrameworkMarshallers.String)
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return ReactiveClass_Unknown(_values, unknownId, unknownBytes).withId(_id)
        }
        
    }
    //fields
    val values: IMutableViewableList<String> get() = _values
    //methods
    //initializer
    init {
        _values.optimizeNested = true
    }
    
    init {
        bindableChildren.add("values" to _values)
    }
    
    //secondary constructor
    constructor(
    ) : this(
        RdList<String>(FrameworkMarshallers.String)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ReactiveClass (")
        printer.indent {
            print("values = "); _values.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ReactiveClass   {
        return ReactiveClass(
            _values.deepClonePolymorphic()
        )
    }
    //contexts
}


class ReactiveClass_Unknown (
    _values: RdList<String>,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : ReactiveClass (
    _values
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<ReactiveClass_Unknown> {
        override val _type: KClass<ReactiveClass_Unknown> = ReactiveClass_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ReactiveClass_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ReactiveClass_Unknown)  {
            value.rdid.write(buffer)
            RdList.write(ctx, buffer, value._values)
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    constructor(
        unknownId: RdId,
        unknownBytes: ByteArray
    ) : this(
        RdList<String>(FrameworkMarshallers.String),
        unknownId,
        unknownBytes
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ReactiveClass_Unknown (")
        printer.indent {
            print("values = "); _values.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ReactiveClass_Unknown   {
        return ReactiveClass_Unknown(
            _values.deepClonePolymorphic(),
            unknownId,
            unknownBytes
        )
    }
    //contexts
}
