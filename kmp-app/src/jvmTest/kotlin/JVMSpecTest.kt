import org.junit.jupiter.api.Test
import ru.otus.otuskotlin.exercise5.JVMSpec
import kotlin.test.assertEquals

class JVMSpecTest {
    @Test
    fun testFoo() {
        val res = JVMSpec().foo()

        assertEquals("sample", res)
    }
}