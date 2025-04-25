package ge.avalanche.zvavi.bulletin.data.mapper

import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin
import ge.avalanche.zvavi.bulletin.api.network.models.HazardLevels
import ge.avalanche.zvavi.database.entities.BulletinEntity
import ge.avalanche.zvavi.database.entities.HazardLevelsEntity
import ge.avalanche.zvavi.network.models.BulletinApi
import ge.avalanche.zvavi.network.models.HazardLevelsApi


// Network -> Domain
fun HazardLevelsApi.toDomain(): HazardLevels = HazardLevels(
    alpine = alpine,
    overall = overall,
    subAlpine = subAlpine,
    highAlpine = highAlpine
)

fun BulletinApi.toDomain(): Bulletin = Bulletin(
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
    alpine = alpine,
    overall = overall,
    subAlpine = subAlpine,
    highAlpine = highAlpine
)

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
    alpine = alpine,
    overall = overall,
    subAlpine = subAlpine,
    highAlpine = highAlpine
)