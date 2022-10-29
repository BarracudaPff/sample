import kotlin.test.Test
import kotlin.test.assertEquals

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class Cash
constructor(
    val amount: BigDecimal,
    var currency: Currency
) {
    fun format(locale: Locale): String {
        val formatter = NumberFormat.getCurrencyInstance(locale)
        formatter.currency = currency
        return formatter.format(amount)
    }

    operator fun minus(other: Cash): Cash {
        require(currency == other.currency) {
            "Summand should be of the same currency"
        }
        return Cash(amount - other.amount, currency)
    }
}

class CashTest {
    @Test
    fun test() {
        val a = Cash(BigDecimal("10"), Currency.getInstance("USD"))
        val b = Cash(BigDecimal("20"), Currency.getInstance("USD"))
        val c = b - a
        //c.amount = BigDecimal.TEN; // ERROR!
        c.currency = Currency.getInstance("RUB");
        println(c.amount)
        println(a)
        println(c.format(Locale.FRANCE))

        assertEquals(c.amount, BigDecimal.TEN);
    }
}
