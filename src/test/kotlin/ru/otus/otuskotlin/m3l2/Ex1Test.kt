import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

data class Rectangle(var height: Int, var width: Int)


class Ex1Test {
    // задание 1 - добавьте инвариант для Rectangle, чтобы его длина и ширина не могли быть отрицательными
    @Test
    fun rectangleInvariant() {
        assertThrows<Exception> {
            Rectangle(-10, 5)
        }
        assertThrows<Exception> {
            Rectangle(5, -5)
        }

        val r = Rectangle(5, 5)
        assertThrows<Exception> {
            r.width = -5
        }

        assertThrows<Exception> {
            r.height = -5
        }
    }

    // задание 2 - сделайте базовый класс Figure и унаследуйте от него Rectangle и Square (тоже сделайте)
    @Test
    fun inheritance() {
        /*val r: Figure = Rectangle(10, 20)
        val s: Figure = Square(10)*/
    }

    // Задание 3 - Добавьте метод area в Figure, переопределите его в Rectangle и Square
    // Реализуйте метод areaDiff(a, b), который возвращает разность площадей фигур

    @Test
    fun polymorphism() {
        /*val r: Figure = Rectangle(10, 20)
        val s: Figure = Square(10)
        assertTrue { r is Figure }
        assertFalse { r is Square }
        assertEquals(r.area(), 200)
        assertEquals(s.area(), 100)
        assertEquals(areaDiff(r, a), 100)*/
    }
}