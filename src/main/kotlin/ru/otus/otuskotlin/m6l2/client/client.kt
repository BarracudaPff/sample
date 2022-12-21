package ru.otus.otuskotlin.m6l2.client

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.Socket


class PingClient(input: InputStream, output: OutputStream) : AutoCloseable {
    private val input: BufferedReader
    private val output: BufferedWriter

    init {
        this.input = BufferedReader(InputStreamReader(input))
        this.output = BufferedWriter(OutputStreamWriter(output))
    }

    fun sendMessage(message: String) {
        output.write("$message\n")
        output.flush()
        val answer = input.readLine()
        println("server answer $answer")
    }

    override fun close() {
        input.close()
        output.close()
    }
}

fun main() {
    println("start client")
    Socket("localhost", 8090).use { socket ->
        val client = PingClient(socket.getInputStream(), socket.getOutputStream())
        client.sendMessage("Hello world")
    }
}
