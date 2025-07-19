package ge.avalanche.zvavi.network.models.recentAvalanches

import kotlinx.serialization.Serializable

@Serializable
data class RecentAvalancheResponse(
    val data: RecentAvalanchesApi
)