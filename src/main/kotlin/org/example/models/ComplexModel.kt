package org.example.models

import com.jetbrains.rd.generator.nova.*

class ComplexModel : Ext(DemoRoot) {
    val reactiveClass = openclass {
        list("values", PredefinedType.string)
    }
}