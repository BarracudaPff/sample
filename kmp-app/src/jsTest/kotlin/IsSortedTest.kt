import ru.otus.otuskotlin.exercise5.sorted
import kotlin.test.Test
import kotlin.test.assertEquals

class IsSortedTest {
    @Test
    fun testIsArraySorted() {
        val arrSorted = arrayOf(1, 2, 3)
        val arrNotSorted = arrayOf(4, 2, 1, 3)

        assertEquals(true, sorted(arrSorted))
        assertEquals(false, sorted(arrNotSorted))
    }
}