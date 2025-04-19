package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json

interface BulletinRemoteDataSource {
    suspend fun getBulletin(): List<Bulletin>
}

class BulletinRemoteDataSourceImpl(
    private val client: HttpClient,
    private val baseUrl: String
) : BulletinRemoteDataSource {
    private val logger = Logger.withTag("BulletinRemoteDataSource")
    private val apiKey =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImduZmdodXVzc3pzeGpkZGZvdXNjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzI0NDA3ODUsImV4cCI6MjA0ODAxNjc4NX0.eNJiMY-rj6dSOla05KHKMY1-BmuBdoT7G1E-Cb_ETws"

    override suspend fun getBulletin(): List<Bulletin> {
        try {
            val response = client.get("${baseUrl}forecasts?order=id.desc&limit=1") {
                header("apikey", apiKey)
            }
            val responseText = response.bodyAsText()
            logger.d { "Response: $responseText" }
            
            if (!response.status.isSuccess()) {
                logger.e { "Failed to get bulletins: ${response.status}" }
                throw Exception("Failed to get bulletins: ${response.status}")
            }
            
            return try {
                Json.decodeFromString<List<Bulletin>>(responseText)
            } catch (e: Exception) {
                logger.e(e) { "Failed to deserialize response: $responseText" }
                throw e
            }
        } catch (e: Exception) {
            logger.e(e) { "Error fetching bulletins" }
            throw e
        }
    }
}

