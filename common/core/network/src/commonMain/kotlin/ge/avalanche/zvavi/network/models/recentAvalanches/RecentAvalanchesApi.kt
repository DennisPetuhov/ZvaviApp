package ge.avalanche.zvavi.network.models.recentAvalanches

import ge.avalanche.zvavi.network.models.addproblems.AspectsApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecentAvalanchesApi(
    val aspects: AspectsApi,
    val date: String,
    val description: String,
    @SerialName("forecast_id")
    val forecastId: Int,
    val id: Int,
    val size: Int
)