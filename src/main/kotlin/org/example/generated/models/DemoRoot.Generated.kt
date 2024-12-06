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
 * #### Generated from [DemoRoot.kt:5]
 */
class DemoRoot private constructor(
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            DemoRoot.register(serializers)
            ComplexModel.register(serializers)
            DemoModel.register(serializers)
        }
        
        
        
        
        
        const val serializationHash = 2990580803186469991L
        
    }
    override val serializersOwner: ISerializersOwner get() = DemoRoot
    override val serializationHash: Long get() = DemoRoot.serializationHash
    
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("DemoRoot (")
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): DemoRoot   {
        return DemoRoot(
        )
    }
    //contexts
}
