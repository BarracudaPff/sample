package ru.otus.otuskotlin.exercise6

fun defangIp(ip: String): String {

    return "1[.]2[.]3[.]4"
}

fun main() {
    println(defangIp("1.1.1.1")) // 1[.]1[.]1[.]1
    println(defangIp("255.100.50.0")) // 255[.]100[.]50[.]0
}