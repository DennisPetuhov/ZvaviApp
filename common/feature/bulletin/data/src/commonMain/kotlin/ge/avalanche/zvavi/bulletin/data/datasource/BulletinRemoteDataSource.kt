package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse
import ge.avalanche.zvavi.network.client.ApiClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess

interface BulletinRemoteDataSource {
    suspend fun getBulletin(): ApiResponse<List<Bulletin>>
}

class BulletinRemoteDataSourceImpl(
    private val apiClient: ApiClient
) : BulletinRemoteDataSource {
    private val logger = Logger.withTag("BulletinRemoteDataSource")

    override suspend fun getBulletin(): ApiResponse<List<Bulletin>> {
        return try {
            val response =
                apiClient.httpClient.request("${apiClient.baseUrl}forecasts?order=id.desc&limit=1") {
                    method = HttpMethod.Get
                }

            if (response.status.isSuccess()) {
                try {
                    val bulletins: List<Bulletin> = response.body()
                    logger.d { "Successfully parsed ${bulletins.size} bulletins" }
                    logger.d { "Successfully parsed ${bulletins.toString()} bulletins" }
                    ApiResponse.Success(bulletins, response.status.value)
                } catch (e: Exception) {
                    logger.e(e) { "Failed to parse bulletins" }
                    ApiResponse.Error(
                        response.status.value,
                        "Failed to parse bulletins: ${e.message}"
                    )
                }
            } else {
                ApiResponse.Error(
                    response.status.value,
                    "Request failed with status code: ${response.status.value}"
                )
            }
        } catch (e: Exception) {
            logger.e(e) { "Network request failed: ${e.message}" }
            ApiResponse.Error(0, "Network request failed: ${e.message}")
        }
    }
}

