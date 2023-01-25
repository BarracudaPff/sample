package actions

import IDRequestModel
import User
import UserRequestModel
import kotlinx.serialization.Serializable

interface UserCreateAction {
    suspend fun create(request: Request): Response

    @Serializable
    data class Request(val req: UserRequestModel)

    sealed class Response {
        @Serializable
        data class Success(val user: User) : Response()
        @Serializable
        data class Failure(val message: String) : Response()
    }
}

interface UserDeleteAction {
    suspend fun delete(request: Request): Response

    @Serializable
    data class Request(val req: IDRequestModel)

    sealed class Response {
        @Serializable
        data class Success(val user: User) : Response()
        @Serializable
        data class Failure(val message: String) : Response()
    }
}

interface UserListAction {
    suspend fun list(): Response

    sealed class Response {
        @Serializable
        data class Success(val users: List<User>) : Response()

        @Serializable
        data class Failure(val message: String) : Response()
    }
}
