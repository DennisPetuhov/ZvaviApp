package ge.avalanche.zvavi.bulletin.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bulletin(
    val id: Int,
    @SerialName("created_at")
    val createdAt: String,
    val forecaster: String,
    val status: String,
    @SerialName("valid_until")
    val validUntil: String,
    val snowpack: String,
    val summary: String,
    val weather: String,
    @SerialName("snow_condition")
    val snowCondition: String,
    @SerialName("additional_hazards")
    val additionalHazards: String,
    @SerialName("hazard_levels")
    val hazardLevels: HazardLevels
) {
    companion object {
        val EMPTY = Bulletin(
            id = 0,
            createdAt = "",
            forecaster = "",
            status = "",
            validUntil = "",
            snowpack = "",
            summary = "",
            weather = "",
            snowCondition = "",
            additionalHazards = "",
            hazardLevels = HazardLevels.EMPTY
        )
    }
}