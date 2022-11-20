package ru.otus.otuskotlin.m4l2.model

import java.time.LocalDate

data class PickupExecutionGroup(
    val type: PickupExecutionGroupType,
    val dates: List<PickupDate>,
)

enum class PickupExecutionGroupType {
    QUICKEST,
    ALL,
}

data class PickupDate(
    val date: LocalDate,
    val applicableTo: Map<String, PickupAvailableItem>,
)

data class PickupAvailableItem(
    val materialNumber: String,
    val itemId: String,
    val prepaid: Boolean,
    val showcase: Boolean,
    val linkedItems: List<Item>,
)

data class Item(
    val materialNumber: String,
    val itemId: String,
)