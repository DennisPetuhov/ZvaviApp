package ge.avalanche.zvavi.network.models.problems

import kotlinx.serialization.Serializable

@Serializable
data class AvalancheProblemResponse(
    val data: AvalancheProblemApi
)