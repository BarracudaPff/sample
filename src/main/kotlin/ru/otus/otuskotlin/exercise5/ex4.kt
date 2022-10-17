package ru.otus.otuskotlin.exercise5

fun main() {
  var a = 10
  val b = 20

  fun iAmLocalFunc(c: Int): Int {
    a += c
    return a + b + c
  }

  println(iAmLocalFunc(22))
  println("a = $a")

  val iAmLocalFunc2 = {c: Int ->
    a -= 2
    c * 2
  }
  println(iAmLocalFunc2(22))
  println("a = $a")

  val y = x(10)
  println(y(5))
  println(y(6))
}

fun x(a: Int): (Int) -> Int {
  return { a + it }
}

