import kotlin.test.Test
import kotlin.test.assertEquals

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class Class2_2(
    val immutableProperty: String = "",
    var mutableProperty: String = ""
) {
    val immutableInnerProperty: String = "Hello!"

    var mutableInnerProperty: String = "world"

    private var field1: Int = 0

    init {
        mutableInnerProperty += mutableProperty
    }

    val field1Immutable: Int
        get() {
            return field1
        }

    var field2: String = "init value"
        get() {
            return field
        }
        set(value) {
            if (value.isBlank()) throw RuntimeException("field empty!")
            field = value
        }


}

class Class2_2Test {
    @Test
    fun test() {
        val a = Class2_2(mutableProperty = "!")
        println(a.mutableProperty)
        println(a.immutableProperty)
        println(a.mutableInnerProperty)
        println(a.immutableInnerProperty)
        println(a.field1Immutable)
        a.field2 = ""
    }
}
