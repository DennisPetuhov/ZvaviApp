package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.BulletinItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess

interface BulletinRemoteDataSource {
    suspend fun getBulletin(): List<BulletinItem>
}

class BulletinRemoteDataSourceImpl(
    private val client: HttpClient,
    private val baseUrl: String
) : BulletinRemoteDataSource {
    private val logger = Logger.withTag("BulletinRemoteDataSource")

    override suspend fun getBulletin(): List<BulletinItem> {
        try {
            val response = client.get("$baseUrl/bulletins")
            if (!response.status.isSuccess()) {
                logger.e { "Failed to get bulletins: ${response.status}" }
                throw Exception("Failed to get bulletins: ${response.status}")
            }
            return response.body()
        } catch (e: Exception) {
            logger.e(e) { "Error fetching bulletins" }
            throw e
        }
    }
} 