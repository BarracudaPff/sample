package ru.otus.otuskotlin.m4l2.model.live

import org.junit.jupiter.api.Test
import ru.otus.otuskotlin.m4l2.model.Item
import ru.otus.otuskotlin.m4l2.model.PickupAvailableItem
import ru.otus.otuskotlin.m4l2.model.PickupDate
import ru.otus.otuskotlin.m4l2.model.PickupExecutionGroup
import ru.otus.otuskotlin.m4l2.model.PickupExecutionGroupType
import java.time.LocalDate


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
        /*val model = buildPickupExecutionGroup {
            type = PickupExecutionGroupType.ALL

            date {
                date = LocalDate.now()
                applicableTo {
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

        println(model)*/
    }
}