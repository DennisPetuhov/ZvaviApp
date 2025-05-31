package ge.avalanche.zvavi.network.models.addproblems

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AspectsApi(
    val alpine: List<String>,
    @SerialName("high_alpine")
    val highAlpine: List<String>,
    @SerialName("sub_alpine")
    val subAlpine: List<String>
)