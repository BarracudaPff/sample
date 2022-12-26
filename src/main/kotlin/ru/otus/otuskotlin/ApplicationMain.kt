package ru.otus.otuskotlin

import info.debatty.java.stringsimilarity.NormalizedLevenshtein

class Main

fun main(args: Array<String>) {
    val l = NormalizedLevenshtein()

    println("Got: " + args.toList())

    if (args.isEmpty()) {
        println("No args")
//        exitProcess(1)
        return
    }

    val first = args.first()
    val res = (Main::class as Any).javaClass.classLoader.getResource(first)

    println(res)
}
