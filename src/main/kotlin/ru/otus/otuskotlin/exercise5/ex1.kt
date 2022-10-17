package ru.otus.otuskotlin.exercise5

fun w(vararg a: Any): Any {
  println(a)
  return 42
}

fun main() {
  println(w(1, 2.0, "qwer", Any()))

  println("Hello from main")

  sum(b = 10, a = 20)

  println("Result: " + sum(10, 20))

  println("Result from funcWithoutResult: " + funcWithoutResult(10.0f))
}

fun sum(a: Int, b: Int): Int {
  println("sum($a, $b)")
  return a + b
}

fun sumShort(a: Int, b: Int): Int = a + b

fun sumShort2(a: Int, b: Int) = a + b

fun funcWithoutResult(a: Float) {
  println("funcWithoutResult($a)")
}

fun funcWithoutResult2(a: Float): Unit {
  println("funcWithoutResult2($a)")
}