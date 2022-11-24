package ru.otus.otuskotlin.m4l2.json.live

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.otus.otuskotlin.m4l2.json.BooleanValue
import ru.otus.otuskotlin.m4l2.json.JsonValue
import ru.otus.otuskotlin.m4l2.json.ListValue
import ru.otus.otuskotlin.m4l2.json.NumberValue
import ru.otus.otuskotlin.m4l2.json.ObjectJson
import ru.otus.otuskotlin.m4l2.json.StringValue

@DslMarker
annotation class JsonMarker

@JsonMarker
abstract class BaseContext {
    fun list(block: ListContext.() -> Unit): ListValue {
        val context = ListContext()
        context.block()
        return ListValue(context.data)
    }

    fun obj(block: ObjectContext.() -> Unit): ObjectJson {
        val context = ObjectContext()
        context.block()
        return ObjectJson(context.properties)
    }
}

class ListContext : BaseContext() {
    val data = mutableListOf<JsonValue>()

    fun add(value: Number) = add(NumberValue(value) as JsonValue)
    fun add(value: Boolean) = add(BooleanValue(value))
    fun add(value: JsonValue) {
        data.add(value)
    }
}

class ObjectContext : BaseContext() {
    val properties = mutableMapOf<String, JsonValue>()

    fun set(name: String, value: JsonValue) {
        if (name in properties) throw IllegalArgumentException("duplicate key: $name")
        properties[name] = value
    }

    operator fun String.divAssign(value: JsonValue) = set(this, value)

    operator fun String.divAssign(number: Number) = set(this,  NumberValue(number))

    operator fun String.divAssign(boolean: Boolean) = set(this,  BooleanValue(boolean))

    operator fun String.divAssign(string: String) = set(this,  StringValue(string))
}

fun jsonObject(block: ObjectContext.() -> Unit): ObjectJson {
    val context = ObjectContext()
    context.block()
    return ObjectJson(context.properties)
}

internal class JsonDslTest {
    @Test
    fun createObject() {
        assertThrows<IllegalArgumentException> {
                jsonObject {
                    "a" /= 1
                    "a" /= 2
                }
        }

        val m = jsonObject {
            "a" /= 2
            "b" /= 2.0
            "c" /= 2L
            "d" /= false
            "e" /= "hello"
            "g" /= list {
                add(1)
                add(true)

                add(list {
                   // "v" set 5 // !!!
                    add(1)
                    add(2)
                })
            }
            "h" /= obj {
                "x" /= "hello"
            }
        }
    }

}