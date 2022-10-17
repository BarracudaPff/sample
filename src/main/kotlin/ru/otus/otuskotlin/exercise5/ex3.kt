package ru.otus.otuskotlin.exercise5

fun main() {
  evaluate(10, 20, { a, b ->
    println("$a, $b")
    a + b
  })

  val c = 22
  var d = 0

  evaluate(10, 20) { a, b ->
    d += 1
    a + b + c
  }

  evaluate(10, 20) { _, _ ->
    22
  }

  doSomething2Times {
    println("x")
  }

  doSomething2Times {
    println("y:$it")
  }

  doSomething2Times { no ->
    println("y:$no")
  }

  evaluate2({a, b -> a + b}) {a, b -> a * b}
}

typealias Evaluator = (Int, Int) -> Int

fun evaluate(a: Int, b: Int, evaluator: (Int, Int) -> Int): Int {
  println("evaluate($a, $b)")
  val res = evaluator(a, b)
  println("result = $res")
  return res
}

fun evaluate2(evaluator1: (Int, Int) -> Int, evaluator2: (Int, Int) -> Int): Int {
  return 42
}

fun doSomething2Times(action: (no: Int) -> Unit) {
  for (i in 0..1) {
    action(i)
  }
}