import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import ru.otus.otuskotlin.exercise5.ApiService
import ru.otus.otuskotlin.exercise5.Logger
import kotlin.test.assertEquals

class ApiServiceJVMTest {

    @Test
    fun `test api call`() = runTest {
        val call = ApiService().call()
        assertEquals("JVM call", call)
    }
}

class LoggerJVMTest {

    @Test
    fun `test logger`()  {
        Logger().log("jvm log")
    }
}
