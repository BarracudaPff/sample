package services

import MissingFieldException
import TeamNotFoundException
import User
import UserNotFoundException
import actions.UserCreateAction
import actions.UserDeleteAction
import actions.UserListAction
import services.db.TeamDbService
import services.db.UserDbService
import java.util.*

class UserService(
    private val teamDb: TeamDbService,
    private val userDb: UserDbService,
) : UserCreateAction, UserDeleteAction, UserListAction {
    override suspend fun create(request: UserCreateAction.Request): UserCreateAction.Response {
        return try {
            //0. get data
            val req = request.req

            //1. validate
            val teamId = req.teamId ?: throw IllegalArgumentException("Team id is null")
            val team = teamDb.getById(teamId) ?: throw TeamNotFoundException(teamId)

            //2. create model + bl
            val user = User(
                req.id ?: UUID.randomUUID().toString(),
                req.nameFirst ?: throw MissingFieldException("nameFirst"),
                req.nameSecond ?: throw MissingFieldException("nameSecond"),
                team,
            )

            //3. store data
            userDb.store(user)

            //4. response
            UserCreateAction.Response.Success(user)
        } catch (e: Exception) {
            UserCreateAction.Response.Failure(e.message ?: "Smth went wrong.")
        }
    }

    override suspend fun delete(request: UserDeleteAction.Request): UserDeleteAction.Response {
        return try {
            //0. get data
            val id = request.req.id ?: throw IllegalArgumentException("Team id is null")

            //1. validate
            val user = userDb.getById(id) ?: throw UserNotFoundException(id)

            //3. store data
            userDb.delete(id)

            //4. response
            UserDeleteAction.Response.Success(user)
        } catch (e: Exception) {
            UserDeleteAction.Response.Failure(e.message ?: "Smth went wrong.")
        }
    }

    override suspend fun list(): UserListAction.Response {
        return try {
            //1. validate
            val users = userDb.getAll()

            //2. response
            UserListAction.Response.Success(users)
        } catch (e: Exception) {
            UserListAction.Response.Failure(e.message ?: "Smth went wrong.")
        }
    }
}
