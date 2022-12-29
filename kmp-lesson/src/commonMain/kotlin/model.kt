import kotlinx.serialization.Serializable

@Serializable
data class CalcData(
    val a: Double,
    val b: Double,
)

@Serializable
data class CalcResult(
    val c: Double,
    val type: String,
)