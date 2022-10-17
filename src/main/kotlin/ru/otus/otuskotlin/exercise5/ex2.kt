package ru.otus.otuskotlin.exercise5

import java.time.LocalTime
import java.util.Arrays

fun main(args: Array<String>) {
  gotoSleep()
  gotoSleep("1:42")

  gotoSleep2()
  gotoSleep2("1:42")

  someFunWithManyArgs(10, c = 15, b = 20)
  someFunWithManyArgs2(10, 20, d=30)

  someFunWithManyArgs(d = 4, c = 3, b = 2, a = 1)

  someFunWithManyArgs(1, 2, d = 4, c = 3)

  funcWithUnknownArgsCount(10)
  funcWithUnknownArgsCount(10, 20, c=7)
  funcWithUnknownArgsCount(10, 20, 30)

  println(factorial(3))
  println(factorial2(3))
  println(factorial3(3))
}

fun gotoSleep(at: String = "0:00") {
  println("at: $at")
}

fun gotoSleep2(at: String = LocalTime.now().toString()) {
  println("at: $at")
}

fun someFunWithManyArgs(a:Int, b:Int, c:Int = 10, d:Int=20) {
  println("a=$a, b=$b, c=$c, d=$d")
}

fun someFunWithManyArgs2(a:Int, b:Int, c:Int = 10, d:Int) {
  println("a=$a, b=$b, c=$c, d=$d")
}

fun funcWithUnknownArgsCount(a: Int, vararg b:Int, c:Int=7) {
  println("a=$a, b=${b.contentToString()}, c=$c")
}

tailrec fun factorial(n:Int):Int {
  if (n<=1) return 1
  return n * factorial(n-1)
}

/**
 * Расчет факториала
 * @param n факториал чего считаем
 * @param accum значение аккамулятора
 * @return значение факториала
 */
tailrec fun factorial2(n: Long, accum: Long = 1): Long {
  val soFar = n * accum
  return if (n <= 1) {
    soFar
  } else {
    factorial2(n - 1, soFar)
  }
}

fun factorial3(n: Long): Long {
  var cur = n
  var res = 1L
  while (cur > 1) {
    res *= cur
    cur -= 1
  }
  return res
}




