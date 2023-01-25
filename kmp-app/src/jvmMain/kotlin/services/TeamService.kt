package services

import MissingFieldException
import Team
import actions.TeamCreateAction
import services.db.TeamDbService
import services.db.UserDbService
import java.util.*

class TeamService(
    private val teamDb: TeamDbService,
    private val userDb: UserDbService,
) : TeamCreateAction {
    override suspend fun create(request: TeamCreateAction.Request): TeamCreateAction.Response {
        return try {
            //0. get data
            val req = request.req

            //1. create model + bl
            val team = Team(
                req.id ?: UUID.randomUUID().toString(),
                req.name ?: throw MissingFieldException("name"),
                emptyList()
            )

            //2. store data
            teamDb.store(team)

            //3. response
            TeamCreateAction.Response.Success(team)
        } catch (e: Exception) {
            TeamCreateAction.Response.Failure(e.message ?: "Smth went wrong.")
        }
    }
}
