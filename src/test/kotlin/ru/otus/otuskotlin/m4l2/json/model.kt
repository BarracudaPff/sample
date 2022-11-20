package ru.otus.otuskotlin.m4l2.json

sealed interface JsonValue
sealed interface Json: JsonValue

class BooleanValue(val value: Boolean): JsonValue

class NumberValue(val value: Number) : Number(), JsonValue {
    override fun toByte() = value.toByte()
    override fun toChar() = value.toChar()
    override fun toDouble() = value.toDouble()
    override fun toFloat() = value.toFloat()
    override fun toInt() = value.toInt()
    override fun toLong() = value.toLong()
    override fun toShort() = value.toShort()
}

class StringValue(val value: String): CharSequence by value, JsonValue

open class ListValue(val data: List<JsonValue>): List<JsonValue> by data, JsonValue

open class ObjectValue(val properties: Map<String, JsonValue>): Map<String, JsonValue> by properties, JsonValue

class ListJson(data: List<JsonValue>): ListValue(data), Json
class ObjectJson(properties: Map<String, JsonValue>): ObjectValue(properties), Json
