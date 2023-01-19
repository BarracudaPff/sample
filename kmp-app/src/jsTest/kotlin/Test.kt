import kotlinx.coroutines.test.runTest
import ru.otus.otuskotlin.exercise5.ApiService
import ru.otus.otuskotlin.exercise5.Logger
import kotlin.test.Test
import kotlin.test.assertEquals

class ApiServiceJSTest {

    @Test
    fun testApiCall() = runTest {
        val call = ApiService().call()
        assertEquals("JS call", call)
    }
}

class LoggerJSTest {
    @Test
    fun testLogger() {
        Logger().log("js log")
    }
}
