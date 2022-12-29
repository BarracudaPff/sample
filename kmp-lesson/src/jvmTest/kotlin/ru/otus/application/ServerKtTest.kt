package ru.otus.application

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ServerKtTest {
    @Test
    fun calcSum() = testApplication {
        application {
            myApplicationModule()
        }

        val response = client.post("/calc/sum") {
            setBody("""{"a":10, "b":20}""")
            header("Content-Type", "application/json")
        }

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("""{"c":30.0,"type":"sum"}""", response.bodyAsText())
    }
}