package ge.avalanche.zvavi.bulletin.api.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Bulletin(
    val id: Int,
    val createdAt: String,
    val forecaster: String,
    val status: String,
    val validUntil: String,
    val snowpack: String,
    val summary: String,
    val weather: String,
    val snowCondition: String,
    val additionalHazards: String,
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