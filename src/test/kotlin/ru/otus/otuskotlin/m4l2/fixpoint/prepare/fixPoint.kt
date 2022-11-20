package ru.otus.otuskotlin.m4l2.fixpoint.prepare

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.pow
import kotlin.test.assertEquals

private fun pow10(p: Int) = 10.0.pow(p)

private fun commonExponent(a: FixPoint, b: FixPoint): Pair<FixPoint, FixPoint> =
    when {
        a.exponent == b.exponent -> a to b
        a.exponent < b.exponent -> a to FixPoint(b.mantissa * pow10(b.exponent - a.exponent).toLong(), a.exponent)
        else -> commonExponent(b, a)
    }

class FixPoint {
    var mantissa: Long = 0
        private set
    var exponent: Int = 0
        private set

    constructor(mantissa: Long, exponent: Int = 0) {
        require(exponent <= 0) { "exponent must be <= 0" }
        this.mantissa = mantissa
        this.exponent = exponent
    }

    constructor(string: String) {
        val pointPos = string.indexOf('.')
        mantissa = (if (pointPos >= 0) string.removeRange(pointPos, pointPos + 1) else string).toLong()
        exponent = if (pointPos < 0) 0 else -(string.length - pointPos - 1)
    }

    constructor(value: Double) : this(value.toString())

    fun toDouble() = mantissa.toDouble() * pow10(exponent)

    override fun equals(other: Any?) = other is FixPoint && mantissa == other.mantissa && exponent == other.exponent
    override fun hashCode() = 31 * mantissa.hashCode() + exponent
    override fun toString() = "FixPoint(mantissa=$mantissa, exponent=$exponent)"

    operator fun plus(b: Long) = this + FixPoint(b)
    operator fun plus(operand: FixPoint): FixPoint {
        val (a, b) = commonExponent(this, operand)
        return FixPoint(a.mantissa + b.mantissa, a.exponent)
    }

    operator fun minus(b: Long) = this - FixPoint(b)
    operator fun minus(operand: FixPoint): FixPoint {
        val (a, b) = commonExponent(this, operand)
        return FixPoint(a.mantissa - b.mantissa, a.exponent)
    }

    // 1 + FixPoint
    // унарный минус
    // умножение
    // сравнение
    // deconstructing

}

class FixPointTest {
    @Test
    fun create() {
        assertEquals(1.23, FixPoint(123, -2).toDouble(), 0.001)
        assertThrows<IllegalArgumentException> { FixPoint(123, 2) }
        assertEquals(123.0, FixPoint(123).toDouble(), 0.001)
    }

    @Test
    fun createFromString() {
        assertEquals(1.23, FixPoint("1.23").toDouble(), 0.001)
        assertEquals(123.0, FixPoint("123").toDouble(), 0.001)
    }

    @Test
    fun createFromDouble() {
        assertEquals(1.23, FixPoint(1.23).toDouble(), 0.001)
        assertEquals(123.0, FixPoint(123.0).toDouble(), 0.001)
    }

    @Test
    fun plus() {
        assertEquals((FixPoint(123, -2) + 2).toDouble(), 3.23, 0.001)
        assertEquals((FixPoint(123, -2) + FixPoint(32, -1)).toDouble(), 4.43, 0.001)
    }
}