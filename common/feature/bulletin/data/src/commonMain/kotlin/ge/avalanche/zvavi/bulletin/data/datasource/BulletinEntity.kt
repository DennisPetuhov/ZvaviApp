package ge.avalanche.zvavi.bulletin.data.datasource

import ge.avalanche.zvavi.bulletin.api.models.BulletinItem
import ge.avalanche.zvavi.bulletin.api.models.HazardLevels

data class BulletinEntity(
    val id: Int,
    val createdAt: String,
    val forecaster: String,
    val status: String,
    val validUntil: String,
    val snowpack: String,
    val summary: String,
    val weather: String,
    val snowCondition: String,
    val additionalHazards: String,
    val hazardLevels: HazardLevels,
  ) {
    fun toBulletinItem() = BulletinItem(
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
    
    companion object {
        fun fromBulletinItem(item: BulletinItem) = BulletinEntity(
            id = item.id,
            createdAt = item.createdAt,
            forecaster = item.forecaster,
            status = item.status,
            validUntil = item.validUntil,
            snowpack = item.snowpack,
            summary = item.summary,
            weather = item.weather,
            snowCondition = item.snowCondition,
            additionalHazards = item.additionalHazards,
            hazardLevels = item.hazardLevels
        )
    }
} 