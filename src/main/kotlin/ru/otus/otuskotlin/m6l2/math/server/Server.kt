package ru.otus.otuskotlin.m6l2.math.server

import java.net.ServerSocket


class Server(port: Int) : AutoCloseable {
    private val serverSocket: ServerSocket

    init {
        serverSocket = ServerSocket(port)
    }

    fun start() {
        println("listen")
        while (true) {
            val socket = serverSocket.accept()
            try {
                println("accept: " + socket.port)
                ClientHandler(socket).use { client -> client.run() }
            } catch (e: Exception) {
                println("exception: $e")
            }
        }
    }

    override fun close() {
        serverSocket.close()
    }
}

fun main() {
    Server(8081).use { server -> server.start() }
}
