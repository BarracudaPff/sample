import ru.otus.otuskotlin.exercise5.Service
import ru.otus.otuskotlin.exercise5.User
import kotlin.test.Test
import kotlin.test.assertEquals

class UserTest {
    @Test
    fun testUser() {
        val user = User("001", "User", 42)

        assertEquals("001", user.id)
        assertEquals("User", user.name)
        assertEquals(42, user.age)
    }
}

class ServiceTest {
    @Test
    fun testService() {
        val service = Service()

        service.doSmth()
    }
}