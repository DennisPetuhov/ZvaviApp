package ge.avalanche.zvavi.network.models.problems

import ge.avalanche.zvavi.network.models.addproblems.AspectsApi
import ge.avalanche.zvavi.network.models.addproblems.TimeOfDayApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AvalancheProblemApi(
    val aspects: AspectsApi,
    @SerialName("avalanche_size")
    val avalancheSize: Int,
    val confidence: String,
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val distribution: String,
    @SerialName("forecast_id")
    val forecastId: Int,
    val id: Int,
    @SerialName("is_all_day")
    val isAllDay: Boolean,
    val sensitivity: String,
    @SerialName("time_of_day")
    val timeOfDay: TimeOfDayApi,
    val trend: String,
    val type: String
)