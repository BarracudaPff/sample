package ru.otus.otuskotlin.m4l3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldContainOnlyDigits
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UUIDTestCase : StringSpec({
    "date should starts with year" {
        val date = currentDate()
        date.take(4)
            .shouldContainOnlyDigits()
    }
    "date should contains T" {
        val date = currentDate()
        date shouldContain "T"
    }
    "date should contain date and time" {
        val data = currentDate().split("T")

        data.size shouldBeExactly 2

        data.first().filter { it == '-' } shouldBe "--"
        data.last().filter { it == ':' } shouldBe "::"
    }
})
