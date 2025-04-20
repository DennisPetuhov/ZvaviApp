package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse
import ge.avalanche.zvavi.network.client.ApiClient
import io.ktor.http.HttpMethod


interface BulletinRemoteDataSource {
    suspend fun getBulletin(): ApiResponse<List<Bulletin>>
}

class BulletinRemoteDataSourceImpl(
    private val apiClient: ApiClient
) : BulletinRemoteDataSource {
    private val logger = Logger.withTag("BulletinRemoteDataSource")

    override suspend fun getBulletin(): ApiResponse<List<Bulletin>> {
        return apiClient.requestList<Bulletin>(
            method = HttpMethod.Get,
            path = "forecasts?order=id.desc&limit=1"
        )
    }
}

