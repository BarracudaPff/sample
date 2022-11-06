package ru.otus.otuskotlin.m3l4.ex7

import kotlin.test.BeforeTest
import kotlin.test.Test

class TestSubject {
    fun f() = "Hello"
}

internal class MyTest {
    //var subject: TestSubject? = null
    lateinit var subject: TestSubject

    @BeforeTest
    fun setup() {
        subject = TestSubject()
    }

    @Test
    fun test() {
        subject.f()
    }
}
