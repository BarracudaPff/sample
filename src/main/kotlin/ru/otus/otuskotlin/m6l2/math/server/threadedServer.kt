package ru.otus.otuskotlin.m6l2.math.server

import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread


class ThreadedServer(port: Int) : AutoCloseable {
    private val serverSocket: ServerSocket

    init {
        serverSocket = ServerSocket(port)
    }

    fun start() {
        println("listen")
        while (true) {
            val socket = serverSocket.accept()
            thread {
                run(socket)
            }
        }
    }

    override fun close() {
        serverSocket.close()
    }

    private fun run(socket: Socket) {
        try {
            println(socket.port.toString() + " accepted")
            ClientHandler(socket).use { client -> client.run() }
        } catch (e: Exception) {
            println(socket.port.toString() + " exception: " + e)
        } finally {
            try {
                socket.close()
            } catch (_: Exception) {
            }
        }
    }
}

fun main() {
    ThreadedServer(8081).use { server -> server.start() }
}
