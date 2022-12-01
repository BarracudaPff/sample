package ru.otus.otuskotlin.m4l4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTestcase {
    @Test
    fun `test user`() {
        val myUser = user {
            name {
                first = "Kirill"
                last = "Krylov"
                // second =
            }
            contacts {
                email = Email("sample@gmail.com")
                phone = Phone("8981123456")
            }
            actions {
                add(Action.UPDATE)
                add(Action.ADD)

                +Action.DELETE
                +Action.READ
            }
            availability {
                monday("8:00")
                friday("10:00")
            }
        }

        assertNotNull(myUser.id)
        assertEquals("Kirill", myUser.firstName)
        assertEquals(null, myUser.secondName)
        assertEquals("sample@gmail.com", myUser.email.value)
    }

    @Test
    fun `test max empty user`() {
        val myUser = user {
            name {
                first = "Test1"
                last = "Test2"
            }
            contacts {
                email = Email("test@test.test")
                phone = Phone("8981123456")
            }
        }

        assertNotNull(myUser.id)
        assertEquals("Test1", myUser.firstName)
        assertEquals(null, myUser.secondName)
        assertEquals("Test2", myUser.lastName)
        assertEquals("test@test.test", myUser.email.value)
        assertEquals("8981123456", myUser.phone.value)
        assertTrue(myUser.actions.isEmpty())
        assertTrue(myUser.available.isEmpty())
    }
}