import kotlin.test.Test
import kotlin.test.assertEquals

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class Cash2_1 (
    val amount: BigDecimal,
    var currency: Currency,
    arg: String
) {
    init {
        println("init: $arg, amount: $amount")
    }

    init {
        println("second init: $arg")
    }
}

class Cash2_1Test {
    @Test
    fun test() {
        val a = Cash2_1(BigDecimal("10"), Currency.getInstance("USD"), "Hello")
        a.amount
        a.currency
        //a.arg
    }
}
