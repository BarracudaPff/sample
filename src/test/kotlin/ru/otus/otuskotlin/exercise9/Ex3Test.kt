import kotlin.test.Test


class Ex3Test {
    // задание 1 - сделайте класс Rectangle, у которого будет width и height
    // а также метод вычисления площади - area()
    // тест ниже должен пройти - раскомментируйте код в нем
    @Test
    fun rectangleArea() {
        /*val r = Rectangle(10, 20)
        assertEquals(r.area(), 200)
        assertEquals(r.width, 10)
        assertEquals(r.height, 20)*/
    }

    // задание 2 - сделайте метод Rectangle.toString()
    // тест ниже должен пройти - раскомментируйте код в нем
    @Test
    fun rectangleToString() {
        /*val r = Rectangle(10, 20)
        assertEquals(r.toString(), "Rectangle(10x20)")
        */
    }

    // задание 3 - сделайте методы Rectangle.equals() и Rectangle.hashCode()
    // тест ниже должен пройти - раскомментируйте код в нем
    @Test
    fun rectangleEquals() {
        /*val a = Rectangle(10, 20)
        val b = Rectangle(10, 20)
        val c = Rectangle(20, 10)
        assertEquals(a, b)
        assertEquals(a.hashCode(), b.hashCode())
        assertFalse (a === b)
        assertNotEquals(a, c)
        */
    }



}