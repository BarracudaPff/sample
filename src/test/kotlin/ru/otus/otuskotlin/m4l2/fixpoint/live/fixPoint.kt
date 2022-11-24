package ru.otus.otuskotlin.m4l2.fixpoint.live

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private fun pow10(p: Int) = 10.0.pow(p)

private fun getMantissa(string: String): Long = string.replace(".", "").toLong()

private fun getExponent(string: String): Int {
    val point = string.indexOf(".")
    return if (point == -1) 0 else -(string.length - point - 1)
}

private fun commonExponent(a: FixPoint, b: FixPoint): Pair<FixPoint, FixPoint> =
    when {
        a.exponent == b.exponent -> a to b
        a.exponent < b.exponent -> a to FixPoint(
            b.mantissa * pow10(b.exponent - a.exponent).toLong(),
            a.exponent
        )
        else -> {
            val (a2, b2) = commonExponent(b, a)
            b2 to a2
        }
    }

data class FixPoint(
    val mantissa: Long,
    val exponent: Int
) {
    init {
        require(exponent <= 0) { "$exponent must be <= 0" }
    }

    constructor(string: String) : this(getMantissa(string), getExponent(string))
    constructor(double: Double) : this(double.toString())

    constructor(long: Long) : this(long, 0)

    fun toDouble(): Double = mantissa * pow10(exponent)
    override fun toString() : String =
        if (exponent == 0) mantissa.toString()
        else {
            val mantissaStr = mantissa.absoluteValue.toString()
            val sb = StringBuilder()
            if (mantissa < 0)
                sb.append("-")
            // 1e-1 123e-4 1e-2=0.01
            if (-exponent >= mantissaStr.length) {
                sb.append("0.")
                repeat(-(mantissaStr.length + exponent)) {
                    sb.append("0")
                }
                sb.append(mantissaStr)
            } else {
                sb.append(mantissaStr)
                sb.insert(sb.length + exponent, '.')
            }
            sb.toString()
        }

    operator fun plus(bArg: FixPoint): FixPoint {
        val (a, b) = commonExponent(this, bArg)
        return FixPoint(a.mantissa + b.mantissa, a.exponent)
    }

    operator fun plus(b: Long): FixPoint = plus(FixPoint(b))

    operator fun minus(bArg: FixPoint): FixPoint {
        val (a, b) = commonExponent(this, bArg)
        return FixPoint(a.mantissa - b.mantissa, a.exponent)
    }

    operator fun unaryMinus() = FixPoint(-mantissa, exponent)

    operator fun compareTo(bArg: FixPoint): Int {
        val (a, b) = commonExponent(this, bArg)
        return a.mantissa.compareTo(b.mantissa)
    }

    // умножение

    // 123 exp -3
}

operator fun Long.plus(b: FixPoint): FixPoint = b + this
operator fun Int.plus(b: FixPoint): FixPoint = b + this.toLong()

infix fun Long.exp(b: Int) = FixPoint(this, b)
infix fun Int.exp(b: Int) = FixPoint(this.toLong(), b)

class FixPointTest {
    @Test
    fun create() {
        assertEquals(FixPoint(123, -2).toDouble(), 1.23)
        assertEquals(FixPoint("1.23").toDouble(), 1.23)
        assertEquals(FixPoint("123").toDouble(), 123.0)
        assertEquals(FixPoint(1.234).toDouble(), 1.234)

        assertEquals((1234 exp -2).toDouble(), 12.34)

        assertThrows<IllegalArgumentException> { FixPoint(10, 5) }
    }

    @Test
    fun testToString() {
        assertEquals(FixPoint("1.23").toString(), "1.23")
        assertEquals(FixPoint("123").toString(), "123")
        assertEquals(FixPoint("0.0123").toString(), "0.0123")
        assertEquals(FixPoint("0.123").toString(), "0.123")
        assertEquals(FixPoint("-0.123").toString(), "-0.123")
        assertEquals(FixPoint("-1.23").toString(), "-1.23")
    }

    @Test
    fun plus() {
        assertEquals((FixPoint("1.23") + FixPoint("3.4")).toDouble(), 4.63)
        assertEquals((FixPoint("1.23") + FixPoint("1.00")).toDouble(), 2.23)
        assertEquals((FixPoint("1.23") + 1).toDouble(), 2.23)
        assertEquals((1 + FixPoint("1.23") + 2).toDouble(), 4.23)
    }

    @Test
    fun minus() {
        assertEquals((FixPoint("1.23") - FixPoint("0.23")).toDouble(), 1.0)
        assertEquals((FixPoint("1.23") - FixPoint("0.2")).toDouble(), 1.03)
        assertEquals((FixPoint("1.3") - FixPoint("0.23")).toDouble(), 1.07)
    }

    @Test
    fun unaryMinus() {
        assertEquals((-FixPoint("1.23")).toDouble(), -1.23)
    }

    @Test
    fun testEquals() {
        assertEquals(FixPoint("1.23"), FixPoint(123, -2))

    }

    @Test
    fun compare() {
        assertTrue(FixPoint("1.23") > FixPoint("0.7"))
        assertTrue(FixPoint("1.23") >= FixPoint("1.23"))

    }
}