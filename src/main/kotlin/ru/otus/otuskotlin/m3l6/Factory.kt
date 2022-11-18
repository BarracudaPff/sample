package ru.otus.otuskotlin.m3l6

interface Notification {
    fun notify(message: String)
}

class SMSNotification : Notification {
    override fun notify(message: String) {
        println("SMS message: $message.")
    }
}

class EmailNotification : Notification {
    override fun notify(message: String) {
        println("Email from: $message!")
    }
}

class PushNotification : Notification {
    override fun notify(message: String) {
        println("Push from mobile")
    }
}

class CustomNotification : Notification {
    override fun notify(message: String) {
        println("Custom: $message")
    }
}

enum class NotificationType {
    SMS,
    Email,
    Push,
    Custom,
}

fun notificationFromType(type: NotificationType): Notification {
    return when (type) {
        NotificationType.SMS -> SMSNotification()
        NotificationType.Email -> EmailNotification()
        NotificationType.Push -> PushNotification()
        NotificationType.Custom -> CustomNotification()
    }
}

fun main() {
    val smsNotification = notificationFromType(NotificationType.SMS)
    smsNotification.notify("Sample text")
}
