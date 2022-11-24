package ru.otus.otuskotlin.m4l2.model.live

import org.junit.jupiter.api.Test
import ru.otus.otuskotlin.m4l2.model.Item
import ru.otus.otuskotlin.m4l2.model.PickupAvailableItem
import ru.otus.otuskotlin.m4l2.model.PickupDate
import ru.otus.otuskotlin.m4l2.model.PickupExecutionGroup
import ru.otus.otuskotlin.m4l2.model.PickupExecutionGroupType

import java.time.LocalDate

@DslMarker
annotation class Builder

@Builder
class PickupExecutionGroupContext {
    lateinit var type: PickupExecutionGroupType
    var dates = mutableListOf<PickupDate>()

    fun date(block: PickupDateContext.() -> Unit) {
        dates.add(PickupDateContext().let {
            it.block()
            it.build()
        })
    }
}

@Builder
class PickupDateContext {
    lateinit var date: LocalDate
    var applicableTo = mutableMapOf<String, PickupAvailableItem>()

    fun applicableTo(name: String, block: PickupAvailableItemContext.() -> Unit) {
        applicableTo[name] = PickupAvailableItemContext().let {
            it.block()
            it.build()
        }
    }

    fun build() = PickupDate(
        date = date,
        applicableTo = applicableTo
    )
}

@Builder
class PickupAvailableItemContext {
    lateinit var materialNumber: String
    lateinit var itemId: String
    var prepaid = false
    var showcase = false
    val linkedItems = mutableListOf<Item>()

    fun linkedItem(block: ItemContext.() -> Unit) {
        val ctx = ItemContext()
        block(ctx)
        linkedItems.add(ctx.build())
    }

    fun build() = PickupAvailableItem(
        materialNumber = materialNumber,
        itemId = itemId,
        prepaid = prepaid,
        showcase = showcase,
        linkedItems = linkedItems,
    )
}

@Builder
class ItemContext {
    lateinit var materialNumber: String
    lateinit var itemId: String

    fun build() = Item(
        materialNumber = materialNumber,
        itemId = itemId
    )
}


fun buildPickupExecutionGroup(block: PickupExecutionGroupContext.() -> Unit): PickupExecutionGroup =
    with (PickupExecutionGroupContext()) {
        block()
        PickupExecutionGroup(
            type = type,
            dates = dates
        )
    }


internal class BuilderTest {
    @Test
    fun testConstructor() {
        val model = PickupExecutionGroup(
            type = PickupExecutionGroupType.ALL,
            dates = listOf(
                PickupDate(
                    date = LocalDate.now(),
                    applicableTo = mapOf("sample" to
                        PickupAvailableItem(
                            itemId = "itemId",
                            prepaid = true,
                            showcase = false,
                            materialNumber = "materialNumber",
                            linkedItems = listOf(
                                Item(
                                    itemId = "linked1",
                                    materialNumber = "material1"
                                ),
                                Item(
                                    itemId = "linked2",
                                    materialNumber = "material2"
                                )
                            )
                        )
                    )
                )
            )
        )
        println(model)
    }

    @Test
    fun testBuilder() {
        val model = buildPickupExecutionGroup {
            type = PickupExecutionGroupType.ALL

            date {
                date = LocalDate.now()
                applicableTo("key") {
                    itemId = "itemId"
                    prepaid = true
                    materialNumber = "materialNumber"

                    linkedItem {
                        itemId = "linked1"
                        materialNumber = "material1"
                    }

                    linkedItem {
                        itemId = "linked2"
                        materialNumber = "material2"
                    }
                }
            }

        }

        println(model)
    }
}