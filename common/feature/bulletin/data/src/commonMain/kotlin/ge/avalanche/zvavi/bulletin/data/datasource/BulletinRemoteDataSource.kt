package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse
import ge.avalanche.zvavi.network.client.ApiClient
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

interface BulletinRemoteDataSource {
    suspend fun getBulletin(): ApiResponse<List<Bulletin>>
}

//class BulletinRemoteDataSourceImpl(
//    private val apiClient: ApiClient
//) : BulletinRemoteDataSource {
//    private val logger = Logger.withTag("BulletinRemoteDataSource")
//
//    override suspend fun getBulletin(): ApiResponse<List<Bulletin>> {
//        return apiClient.requestList(
//            method = io.ktor.http.HttpMethod.Get,
//            path = "forecasts?order=id.desc&limit=1"
//        ).onError { code, message, details ->
//            logger.e { "Failed to get bulletins: $message (code: $code)" }
//        }
//    }
//}

class BulletinRemoteDataSourceImpl(
    private val apiClient: ApiClient
) : BulletinRemoteDataSource {
    private val logger = Logger.withTag("BulletinRemoteDataSource")

    override suspend fun getBulletin(): ApiResponse<List<Bulletin>> {
        return try {
            val response = apiClient.httpClient.request("${apiClient.baseUrl}forecasts?order=id.desc&limit=1") {
                method = HttpMethod.Get
            }
            
            val responseText = response.bodyAsText()
            val statusCode = response.status.value
            if (response.status.isSuccess()) {
                try {
                    // Parse the JSON array manually
                    val json = apiClient.json
                    val jsonElement = json.parseToJsonElement(responseText)
                    
                    if (jsonElement is JsonObject && jsonElement.containsKey("data")) {
                        // If it's wrapped in a data field
                        val dataElement = jsonElement["data"]
                        val bulletins = parseBulletinsFromJson(dataElement!!, json)
                        logger.d() { "Parse bulletins: $responseText" }
                        ApiResponse.Success(bulletins, statusCode)
                    } else {
                        // If it's directly an array
                        val bulletins = parseBulletinsFromJson(jsonElement, json)
                        ApiResponse.Success(bulletins, statusCode)
                    }
                } catch (e: Exception) {
                    logger.e(e) { "Failed to parse bulletins: $responseText" }
                    ApiResponse.Error(statusCode, "Failed to parse bulletins: ${e.message}", responseText)
                }
            } else {
                val errorMessage = try {
                    val jsonElement = apiClient.json.parseToJsonElement(responseText)
                    if (jsonElement is JsonObject) {
                        jsonElement["message"]?.jsonPrimitive?.content ?: "Unknown error"
                    } else {
                        "Unknown error"
                    }
                } catch (e: Exception) {
                    "Error with status code: $statusCode"
                }
                ApiResponse.Error(statusCode, errorMessage, responseText)
            }
        } catch (e: Exception) {
            logger.e(e) { "Network request failed: ${e.message}" }
            ApiResponse.Error(0, "Network request failed: ${e.message}")
        }
    }
    
    private fun parseBulletinsFromJson(jsonElement: JsonElement, json: Json): List<Bulletin> {
        val bulletins = mutableListOf<Bulletin>()
        
        // Handle array of bulletins
        if (jsonElement.jsonArray.isNotEmpty()) {
            for (item in jsonElement.jsonArray) {
                try {
                    val bulletin = parseBulletinFromJson(item.jsonObject, json)
                    bulletins.add(bulletin)
                } catch (e: Exception) {
                    logger.e(e) { "Failed to parse bulletin: ${item.toString()}" }
                }
            }
        }
        
        return bulletins
    }
    
    private fun parseBulletinFromJson(jsonObject: JsonObject, json: Json): Bulletin {
        val id = jsonObject["id"]?.jsonPrimitive?.content?.toIntOrNull() ?: 0
        val createdAt = jsonObject["created_at"]?.jsonPrimitive?.content ?: ""
        val forecaster = jsonObject["forecaster"]?.jsonPrimitive?.content ?: ""
        val status = jsonObject["status"]?.jsonPrimitive?.content ?: ""
        val validUntil = jsonObject["valid_until"]?.jsonPrimitive?.content ?: ""
        val snowpack = jsonObject["snowpack"]?.jsonPrimitive?.content ?: ""
        val summary = jsonObject["summary"]?.jsonPrimitive?.content ?: ""
        val weather = jsonObject["weather"]?.jsonPrimitive?.content ?: ""
        val snowCondition = jsonObject["snow_condition"]?.jsonPrimitive?.content ?: ""
        val additionalHazards = jsonObject["additional_hazards"]?.jsonPrimitive?.content ?: ""
        
        // Parse hazard levels
        val hazardLevelsJson = jsonObject["hazard_levels"]?.jsonObject
        val hazardLevels = if (hazardLevelsJson != null) {
            val alpine = hazardLevelsJson["alpine"]?.jsonPrimitive?.content ?: ""
            val overall = hazardLevelsJson["overall"]?.jsonPrimitive?.content ?: ""
            val subAlpine = hazardLevelsJson["sub_alpine"]?.jsonPrimitive?.content ?: ""
            val highAlpine = hazardLevelsJson["high_alpine"]?.jsonPrimitive?.content ?: ""
            
            ge.avalanche.zvavi.bulletin.api.models.HazardLevels(
                alpine = alpine,
                overall = overall,
                subAlpine = subAlpine,
                highAlpine = highAlpine
            )
        } else {
            ge.avalanche.zvavi.bulletin.api.models.HazardLevels.EMPTY
        }
        
        return Bulletin(
            id = id,
            createdAt = createdAt,
            forecaster = forecaster,
            status = status,
            validUntil = validUntil,
            snowpack = snowpack,
            summary = summary,
            weather = weather,
            snowCondition = snowCondition,
            additionalHazards = additionalHazards,
            hazardLevels = hazardLevels
        )
    }
}

