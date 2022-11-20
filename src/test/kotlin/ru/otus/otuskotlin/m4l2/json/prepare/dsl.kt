package ru.otus.otuskotlin.m4l2.json.prepare

import org.junit.jupiter.api.Test
import ru.otus.otuskotlin.m4l2.json.BooleanValue
import ru.otus.otuskotlin.m4l2.json.JsonValue
import ru.otus.otuskotlin.m4l2.json.ListValue
import ru.otus.otuskotlin.m4l2.json.NumberValue
import ru.otus.otuskotlin.m4l2.json.ObjectJson
import ru.otus.otuskotlin.m4l2.json.ObjectValue
import ru.otus.otuskotlin.m4l2.json.StringValue

@DslMarker
annotation class JsonMarker

//@JsonMarker
sealed class BaseContext {
    fun list(block: ListContext.() -> Unit): ListValue {
        val context = ListContext()
        context.block()
        return ListValue(context.data)
    }

    fun obj(block: ObjectContext.() -> Unit): ObjectValue {
        val context = ObjectContext()
        context.block()
        return ObjectValue(context.properties)
    }
}

class ObjectContext: BaseContext() {
    val properties = mutableMapOf<String, JsonValue>()

    operator fun String.divAssign(value: Int) = set(NumberValue(value))

    infix fun String.set(value: Int) = set(NumberValue(value))

    infix fun String.set(value: Boolean) = set(BooleanValue(value))

    infix fun String.set(value: String) = set(StringValue(value))

    infix fun String.set(value: JsonValue) {
        properties[this] = value
    }
}

class ListContext: BaseContext() {
    val data = mutableListOf<JsonValue>()

    fun add(value: Int) = add(NumberValue(value))
    fun add(value: Boolean) = add(BooleanValue(value))
    fun add(value: JsonValue) {
        data.add(value)
    }
}

fun jsonObject(block: ObjectContext.() -> Unit): ObjectJson {
    val context = ObjectContext()
    context.block()
    return ObjectJson(context.properties)
}


internal class JsonDslTest {
    @Test
    fun createObject() {
        val json = jsonObject {
            "a" /= 2
            "b" set false
            "c" set list {
                add(1)
                add(true)
                add(list {
                   // "v" set 5 // !!!
                    add(1)
                    add(2)
                })
            }
            "d" set obj {
                "x" set "hello"
            }
        }
    }

}