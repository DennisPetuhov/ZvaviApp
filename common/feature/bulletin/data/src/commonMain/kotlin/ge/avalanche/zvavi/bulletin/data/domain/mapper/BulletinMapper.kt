package ge.avalanche.zvavi.bulletin.data.domain.mapper

import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.bulletin.api.models.HazardLevels
import ge.avalanche.zvavi.database.entities.AvalancheRiskLevelEntity
import ge.avalanche.zvavi.database.entities.BulletinEntity
import ge.avalanche.zvavi.database.entities.HazardLevelsEntity
import ge.avalanche.zvavi.network.models.BulletinApi
import ge.avalanche.zvavi.network.models.HazardLevelsApi

// Network -> Entity
fun BulletinApi.toEntity(): BulletinEntity = BulletinEntity(
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
    hazardLevels = hazardLevels.toEntity()
)

fun HazardLevelsApi.toEntity(): HazardLevelsEntity = HazardLevelsEntity(
    alpine = stringToAvalancheRiskLevel(alpine),
    overall = stringToAvalancheRiskLevel(overall),
    subAlpine = stringToAvalancheRiskLevel(subAlpine),
    highAlpine = stringToAvalancheRiskLevel(highAlpine)
)

/**
 * Converts a string value to AvalancheRiskLevelEntity enum
 * @param value The string value to convert
 * @return The corresponding AvalancheRiskLevelEntity enum value
 */
fun stringToAvalancheRiskLevel(value: String): AvalancheRiskLevelEntity {
    return when (value) {
        "0" -> AvalancheRiskLevelEntity.GENERAL_INFORMATION
        "1" -> AvalancheRiskLevelEntity.LOW
        "2" -> AvalancheRiskLevelEntity.MODERATE
        "3" -> AvalancheRiskLevelEntity.CONSIDERABLE
        "4" -> AvalancheRiskLevelEntity.HIGH
        "5" -> AvalancheRiskLevelEntity.EXTREME
        else -> AvalancheRiskLevelEntity.GENERAL_INFORMATION // Default to NONE if value is not recognized
    }
}

// Entity -> Domain
fun BulletinEntity.toDomain(): Bulletin = Bulletin(
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
    hazardLevels = hazardLevels.toDomain()
)

fun HazardLevelsEntity.toDomain(): HazardLevels = HazardLevels(
    alpine = alpine.toDomain(),
    overall = overall.toDomain(),
    subAlpine = subAlpine.toDomain(),
    highAlpine = highAlpine.toDomain()
)

fun AvalancheRiskLevelEntity.toDomain(): AvalancheRiskLevel {
    return AvalancheRiskLevel.entries.find { it.value == this.value } ?: AvalancheRiskLevel.NO_INFO
}