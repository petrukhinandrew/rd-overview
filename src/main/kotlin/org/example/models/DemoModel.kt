package org.example.models

import com.jetbrains.rd.generator.nova.*

class DemoModel : Ext(DemoRoot) {
    val parentStruct = basestruct {
        field("parentField", PredefinedType.string)
    }
    val childStruct = structdef extends parentStruct {
        field("childField", PredefinedType.string)
    }
    val anotherChildStruct = structdef extends parentStruct {
        field("anotherChildField", PredefinedType.string)
    }
    val simpleRequest = structdef {
        field("value", PredefinedType.int)
    }

    init {
        call("makeChildStruct", simpleRequest, childStruct)
        signal("callResultReceived", parentStruct.nullable)
    }
}