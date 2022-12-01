package ru.otus.otuskotlin.m4l4

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.TemporalAdjusters
import java.util.*

class NameContext {
    var first = ""
    var second: String? = null
    var last = ""
}

class ContactsContext {
    var email = Email.NONE
    var phone = Phone.NONE
}

class ActionsContext {
    private val _actions = mutableListOf<Action>()

    val actions
        get() = _actions.toList()

    fun add(action: Action) = _actions.add(action)

    operator fun Action.unaryPlus() = add(this)
}

class AvailabilityContext {
    private val _availabilities = mutableListOf<LocalDateTime>()

    val availabilities
        get() = _availabilities.toList()

    fun sunday(time: String) = dayTimeOfWeek(DayOfWeek.SUNDAY, time)
    fun monday(time: String) = dayTimeOfWeek(DayOfWeek.MONDAY, time)
    fun tuesday(time: String) = dayTimeOfWeek(DayOfWeek.TUESDAY, time)
    fun wednesday(time: String) = dayTimeOfWeek(DayOfWeek.WEDNESDAY, time)
    fun thursday(time: String) = dayTimeOfWeek(DayOfWeek.THURSDAY, time)
    fun friday(time: String) = dayTimeOfWeek(DayOfWeek.FRIDAY, time)
    fun saturday(time: String) = dayTimeOfWeek(DayOfWeek.SATURDAY, time)

    private fun dayTimeOfWeek(dayOfWeek: DayOfWeek, time: String) {
        val day = LocalDate.now().with(TemporalAdjusters.next(dayOfWeek))
        val dayTime = time.split(":")
            .map { it.toInt() }
            .let { (hours, minutes) -> LocalTime.of(hours, minutes) }

        _availabilities.add(LocalDateTime.of(day, dayTime))
    }
}

class UserDsl {
    private val id = UUID.randomUUID().toString()

    private val nameContext = NameContext()
    private val contactsContext = ContactsContext()
    private val actionsContext = ActionsContext()
    private val availabilityContext = AvailabilityContext()

    fun name(block: NameContext.() -> Unit) = nameContext.apply(block)
    fun contacts(block: ContactsContext.() -> Unit) = contactsContext.apply(block)
    fun actions(block: ActionsContext.() -> Unit) = actionsContext.apply(block)
    fun availability(block: AvailabilityContext.() -> Unit) = availabilityContext.apply(block)

    fun build() = User(
        id,
        nameContext.first,
        nameContext.second,
        nameContext.last,
        contactsContext.email,
        contactsContext.phone,
        actionsContext.actions,
        availabilityContext.availabilities,
    )
}

fun user(block: UserDsl.() -> Unit) = UserDsl().apply(block).build()

//fun user(block: UserDsl.() -> Unit): User {
//    val builder = UserDsl()
//    builder.block()
//    return builder.build()
//}
