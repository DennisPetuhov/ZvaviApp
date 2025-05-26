package ge.avalanche.zvavi.network.models

import ge.avalanche.zvavi.network.models.problems.AvalancheProblemResponse
import ge.avalanche.zvavi.network.models.addproblems.BulletinResponse
import ge.avalanche.zvavi.network.models.recentAvalanches.RecentAvalancheResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BulletinApi(
    @SerialName("avalanche_problems")
    val avalancheProblemsResponse: List<AvalancheProblemResponse>,
    @SerialName("forecast")
    val bulletinResponse: BulletinResponse,
    @SerialName("recent_avalanches")
    val recentAvalanchesResponse: List<RecentAvalancheResponse>
)