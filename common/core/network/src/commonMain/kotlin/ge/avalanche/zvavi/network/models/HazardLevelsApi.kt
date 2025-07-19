package ge.avalanche.zvavi.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HazardLevelsApi(
    val alpine: String,
    val overall: String,
    @SerialName("sub_alpine")
    val subAlpine: String,
    @SerialName("high_alpine")
    val highAlpine: String
)