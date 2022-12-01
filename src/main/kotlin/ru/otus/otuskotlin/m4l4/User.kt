package ru.otus.otuskotlin.m4l4

import java.time.LocalDateTime

data class User(
    val id: String,

    val firstName: String,
    val secondName: String?,
    val lastName: String,

    val email: Email,
    val phone: Phone,

    val actions: List<Action>,
    val available: List<LocalDateTime>,
)

enum class Action {
    READ,
    WRITE,
    CREATE,
    UPDATE,
    ADD,
    DELETE,
}

@JvmInline
value class Email(val value: String) {
    override fun toString() = value

    companion object {
        val NONE = Email("")
    }
}

@JvmInline
value class Phone(val value: String) {
    override fun toString() = value

    companion object {
        val NONE = Phone("")
    }
}
