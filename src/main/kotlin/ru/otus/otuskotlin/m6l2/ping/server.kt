package ru.otus.otuskotlin.m6l2.ping

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.ServerSocket

class PingServer(port: Int) : AutoCloseable {
    private val sSocket: ServerSocket

    init {
        sSocket = ServerSocket(port)
    }

    fun start() {
        val openedSocket = sSocket.accept()
        BufferedReader(InputStreamReader(openedSocket.getInputStream())).use { `in` ->
            BufferedWriter(OutputStreamWriter(openedSocket.getOutputStream())).use { out ->
                val inputMessage = `in`.readLine()
                println("get message $inputMessage")
                out.write("pong: $inputMessage\n")
                out.flush()
            }
        }
    }

    override fun close() {
        sSocket.close()
    }
}

fun main() {
    PingServer(8090).use {
        it.start()
    }
}