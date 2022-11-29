package ru.otus.otuskotlin.m4l3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

class JunitTestCase {
    @Test
    fun `simple test`() {
        val num1 = 123
        val num2 = 321

        val res = 444

        assertEquals(444, num1 + num2)
        assertEquals(444, num1 + num2, "Sum of $num1 and $num2")
        assertEquals(444, num1 + num2) {
            "Sum of $num1 and $num2"
        }
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JunitLifecycle {
    lateinit var operation: String

    @BeforeAll
    fun setUp() {
        operation = "+"
    }

    @Test
    fun testMyCode1() {
        assertEquals(operation,"+")
    }

    @Test
    fun testMyCode2() {
        assertEquals(operation,"+")
    }

    @AfterAll
    fun tearDown() {
        operation = "_"
    }
}

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class JunitOrderTestCase {
    @Test
    @Order(1)
    fun testFirst() {

    }

    @Test
    @DisplayName("this is my second test")
    @Order(2)
    fun testSecond() {

    }
}
