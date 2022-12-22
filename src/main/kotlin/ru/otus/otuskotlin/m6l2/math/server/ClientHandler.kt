package ru.otus.otuskotlin.m6l2.math.server

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket


internal class ClientHandler(socket: Socket) : AutoCloseable {
    private val inputStream: DataInputStream
    private val outputStream: DataOutputStream

    init {
        inputStream = DataInputStream(BufferedInputStream(socket.getInputStream()))
        outputStream = DataOutputStream(BufferedOutputStream(socket.getOutputStream()))
    }

    fun run() {
        while (true) {
            when (val command = inputStream.readUTF()) {
                "add" -> {
                    val a = inputStream.readInt()
                    val b = inputStream.readInt()
                    println("add: $a, $b")
                    outputStream.writeInt(a + b)
                    outputStream.flush()
                }
                else -> throw UnsupportedOperationException("Unknown command: $command")
            }
        }
    }

    override fun close() {
        inputStream.close()
        outputStream.close()
    }
}