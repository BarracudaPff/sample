import kotlinx.serialization.Serializable

interface Model {
    val id: String
}

@Serializable
data class User(
    override val id: String,
    val nameFirst: String,
    val nameSecond: String,
    val team: Team
) : Model

@Serializable
data class Team(
    override val id: String,
    val name: String,
    val users: List<User>,
)  : Model
