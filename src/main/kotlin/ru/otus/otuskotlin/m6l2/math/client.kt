package ru.otus.otuskotlin.m6l2.math

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket
import java.util.*


class Client(inputStream: InputStream, outputStream: OutputStream) : AutoCloseable {
    private val inputStream: DataInputStream
    private val outputStream: DataOutputStream

    init {
        this.inputStream = DataInputStream(BufferedInputStream(inputStream))
        this.outputStream = DataOutputStream(BufferedOutputStream(outputStream))
    }

    fun add(a: Int, b: Int): Int {
        outputStream.writeUTF("add")
        outputStream.writeInt(a)
        outputStream.writeInt(b)
        outputStream.flush()
        return inputStream.readInt()
    }

    override fun close() {
        inputStream.close()
        outputStream.close()
    }
}


fun main() {
    Socket("localhost", 8081).use { socket ->
        Client(socket.getInputStream(), socket.getOutputStream()).use { client ->
            val scanner = Scanner(System.`in`)
            while (true) {
                println("""
					1 - add
					0 - exit""")
                when (scanner.nextInt()) {
                    0 -> return
                    1 -> {
                        println("add: a, b:")
                        println("result: " + client.add(scanner.nextInt(), scanner.nextInt()))
                    }
                }
            }
        }
    }
}
