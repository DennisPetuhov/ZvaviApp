package ge.avalanche.zvavi.network.models.addproblems

import kotlinx.serialization.Serializable

@Serializable
data class TimeOfDayApi(
    val end: String?=null,
    val start: String?=null
)