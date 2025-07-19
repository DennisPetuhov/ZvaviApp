package ge.avalanche.zvavi.network.models.addproblems

import ge.avalanche.zvavi.network.models.ForecastApi
import kotlinx.serialization.Serializable

@Serializable
data class BulletinResponse(
    val data: ForecastApi
)