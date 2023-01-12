package ru.otus

import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    private fun test(block: suspend ApplicationTestBuilder.() -> Unit) = testApplication {
        application {
            module()
        }
        block()
    }

    private fun ApplicationTestBuilder.client(user: String, password: String) = createClient {
        defaultRequest {
            val credentials = Base64.getEncoder().encodeToString("$user:$password".toByteArray())
            header(HttpHeaders.Authorization, "Basic $credentials")
        }
    }

    @Test
    fun testOk() = test {
        client("Vasya", "123").get("/auth-basic").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello, Vasya. You use auth-basic", bodyAsText())
        }
    }

    @Test
    fun testNoAuth() = test {
        client.get("/auth-basic").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }

    @Test
    fun testInvalidUser() = test {
        client("Kolya", "123").get("/auth-basic").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }
}