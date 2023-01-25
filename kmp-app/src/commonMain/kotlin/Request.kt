import kotlinx.serialization.Serializable

interface RequestModel

@Serializable
data class UserRequestModel(
    var nameFirst: String? = null,
    var nameSecond: String? = null,
    var teamId: String? = null,
    var id: String? = null,
) : RequestModel

@Serializable
data class TeamRequestModel(
    var name: String? = null,
    var id: String? = null,
) : RequestModel

@Serializable
data class IDRequestModel(
    var id: String? = null,
) : RequestModel
