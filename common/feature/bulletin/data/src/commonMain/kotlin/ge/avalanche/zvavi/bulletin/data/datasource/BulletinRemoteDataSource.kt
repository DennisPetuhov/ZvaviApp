package ge.avalanche.zvavi.bulletin.data.datasource

import ge.avalanche.zvavi.foundation.network.ApiResponse
import ge.avalanche.zvavi.network.client.ApiClient
import ge.avalanche.zvavi.network.models.BulletinApi
import io.ktor.http.HttpMethod


interface BulletinRemoteDataSource {
    suspend fun getBulletin(): ApiResponse<BulletinApi>
}

class BulletinRemoteDataSourceImpl(
    private val apiClient: ApiClient
) : BulletinRemoteDataSource {
    override suspend fun getBulletin(): ApiResponse<BulletinApi> {
        return apiClient.requestBulletin<BulletinApi>(
            method = HttpMethod.Get,
            path = "rpc/get_latest_published_forecast_with_related"
        )
    }
}