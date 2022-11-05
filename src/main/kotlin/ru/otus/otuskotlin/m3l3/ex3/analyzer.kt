package ru.otus.otuskotlin.m3l3.ex3

import java.io.BufferedReader
import java.io.FileReader
import java.util.regex.Pattern

data class LogLine(
    val data: String,
    val level: String,
    val trace: String,
    val component: String,
    val message: String
)

abstract class BaseLogAnalyzer {
    companion object {
        private val pattern =
            Pattern.compile("""(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}\.\d{3}) (\w+) \d \[(\w*)] --- \[\s*([^]]*)] [(\w.*)]+\s*: (.*)""");
    }

    protected open fun before(name: String) {

    }

    protected open fun after(name: String) {

    }

    protected open fun onError(line: String) {

    }

    protected abstract fun process(line: LogLine)


    fun analyze(name: String) {
        BufferedReader(FileReader(name)).use { file ->
            file.lines()
                .map { line ->
                    val match = pattern.matcher(line)
                    if (!match.find()) {
                        onError(line)
                        null
                    } else
                        LogLine(match.group(1), match.group(2), match.group(3), match.group(4), match.group(5))
                }
                .forEach {
                    if (it != null)
                        process(it)
                }
        }
    }
}

class CounterAnalyzer : BaseLogAnalyzer() {
    var count = 0
        private set

    override fun process(line: LogLine) {
        if (line.level == "ERROR") count += 1
    }
}

fun main() {
    val counter = CounterAnalyzer()
    counter.analyze("log.txt")
    println(counter.count)
}