@file:Suppress("PackageDirectoryMismatch")

package ru.otus.otuskotlin.m3l6.command

interface Shape

data class Line(val len: Double) : Shape
data class Rect(val width: Double, val height: Double) : Shape

abstract class DrawCommand(private val canvas: Canvas) {
    private var prevState = emptyList<Shape>()

    abstract fun draw()

    fun saveState() {
        prevState = canvas.state.toList()
    }

    fun undoState() {
        canvas.state = prevState.toMutableList()
    }
}

class DrawLine(private val len: Double, private val canvas: Canvas) : DrawCommand(canvas) {
    override fun draw() {
        saveState()
        canvas.draw(Line(len))
    }
}

class DrawRect(
    private val width: Double,
    private val height: Double,
    private val canvas: Canvas
) : DrawCommand(canvas) {
    override fun draw() {
        saveState()
        canvas.draw(Rect(width, height))
    }
}

class Canvas {
    var state: MutableList<Shape> = mutableListOf()

    fun draw(shape: Shape) {
        println("Drawing $shape...")
        state.add(shape)
    }
}

fun main() {
    val canvas = Canvas()
    val history = mutableListOf<DrawCommand>()

    val drawLine = DrawLine(2.0, canvas)
    drawLine.draw()
    history.add(drawLine)

    val drawRect = DrawRect(10.0, 9.0, canvas)
    drawRect.draw()
    history.add(drawRect)

    println(canvas.state)

    history.first().undoState()

    println(canvas.state)
}