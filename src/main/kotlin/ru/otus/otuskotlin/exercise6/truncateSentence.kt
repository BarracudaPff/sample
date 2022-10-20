package ru.otus.otuskotlin.exercise6

/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
Each of the words consists of only uppercase and lowercase English letters (no punctuation).

    For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.

You are given a sentence s and an integer k. You want to truncate s such that it contains only the first k words.
 */
fun truncateSentence(sentence: String, k: Int): List<String> {
    return listOf()
}

fun main() {
    println(truncateSentence("Hello how are you Contestant", 4)) // ["Hello", "how", "are", "you"]
    println(truncateSentence("What is the solution to this problem", 4)) // ["What", "is", "the", "solution"]
}