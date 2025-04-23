package ge.avalanche.zvavi.bulletin.api.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HazardLevels(
    val alpine: String,
    val overall: String,
    @SerialName("sub_alpine")
    val subAlpine: String,
    @SerialName("high_alpine")
    val highAlpine: String
){
    companion object{
        val EMPTY = HazardLevels(
            alpine = "",
            overall = "",
            subAlpine = "",
            highAlpine = ""
        )
    }
}