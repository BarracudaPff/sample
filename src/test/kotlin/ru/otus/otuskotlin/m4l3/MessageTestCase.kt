package ru.otus.otuskotlin.m4l3

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class MessageTestCase {

    @Test
    fun `test message without par-ms`() {
        val msg = getMessage()

        Assertions.assertInstanceOf(String::class.java, msg)
    }

    @Test
    fun `test message with name`() {
        val msg = getMessage("Bob")

        Assertions.assertEquals("Hello, Bob!", msg)
    }

    @Test
    fun `test message with another name`() {
        val msg = getMessage("Anna")

        Assertions.assertEquals("Hello, Anna!", msg)
    }

    @Test
    fun `test message without name`() {
        val msg = getMessage()

        Assertions.assertEquals("Hello, my friend!", msg)
    }

    @Test
    fun `test message with caps name`() {
        val msg = getMessage("JANE")

        Assertions.assertEquals("HELLO, JANE!", msg)
    }

    @Test
    fun `test message with multiple name`() {
        val msg = getMessage("Bob", "Anna")

        Assertions.assertEquals("Hello, Bob, Anna!", msg)
    }

    @Test
    fun `test message with more names`() {
        val msg = getMessage("Bob", "Anna", "Jane")

        Assertions.assertEquals("Hello, Bob, Anna, Jane!", msg)
    }
}
