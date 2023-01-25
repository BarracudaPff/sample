package actions

import IDRequestModel
import Team
import TeamRequestModel
import kotlinx.serialization.Serializable

interface TeamCreateAction {
    suspend fun create(request: Request): Response

    @Serializable
    data class Request(val req: TeamRequestModel)

    sealed class Response {
        @Serializable
        data class Success(val team: Team) : Response()
        @Serializable
        data class Failure(val message: String) : Response()
    }
}

interface TeamDeleteAction {
    suspend fun delete(request: Request): Response

    @Serializable
    data class Request(val req: IDRequestModel)

    sealed class Response {
        @Serializable
        data class Success(val team: Team) : Response()
        @Serializable
        data class Failure(val message: String) : Response()
    }
}

interface TeamUpdateAction {
    suspend fun update(request: Request): Response

    @Serializable
    data class Request(val req: TeamRequestModel)

    sealed class Response {
        @Serializable
        data class Success(val team: Team) : Response()
        @Serializable
        data class Failure(val message: String) : Response()
    }
}
