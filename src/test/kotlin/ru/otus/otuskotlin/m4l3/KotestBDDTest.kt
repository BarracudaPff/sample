package ru.otus.otuskotlin.m4l3

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeExactly

fun sum(a: Int, b: Int): Int {
    return a + b
}

class KotestBDDTest : BehaviorSpec({
    Given("State A") {
        println("state A ..")

        When("Action B") {
            println("in state A apply action B..")

            Then("State => C") {
                println("state is C now")
            }
        }
    }

    Given("a is 1 and b is 2") {
        val a = 1
        val b = 2
        When("applied sum") {
            val sum = sum(a, b)
            Then("sum must be 3") {
                sum shouldBeExactly 3
            }
        }
    }
})
