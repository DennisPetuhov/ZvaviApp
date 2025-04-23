package ge.avalanche.zvavi.bulletin.data.mapper

import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin
import ge.avalanche.zvavi.bulletin.api.network.models.HazardLevels
import ge.avalanche.zvavi.database.entity.bulletin.BulletinEntity
import ge.avalanche.zvavi.database.entity.bulletin.HazardLevelsEntity
import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin as NetworkBulletin
import ge.avalanche.zvavi.bulletin.api.network.models.HazardLevels as NetworkHazardLevels

// Network -> Domain
fun NetworkBulletin.toDomain(): Bulletin = Bulletin(
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

fun NetworkHazardLevels.toDomain(): HazardLevels = HazardLevels(
    alpine = alpine,
    overall = overall,
    subAlpine = subAlpine,
    highAlpine = highAlpine
)

// Network -> Entity
fun NetworkBulletin.toEntity(): BulletinEntity = BulletinEntity(
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

fun NetworkHazardLevels.toEntity(): HazardLevelsEntity = HazardLevelsEntity(
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

// Extension functions for collections
fun List<NetworkBulletin>.toDomainList(): List<Bulletin> = map { it.toDomain() }
fun List<NetworkBulletin>.toEntityList(): List<BulletinEntity> = map { it.toEntity() }
fun List<BulletinEntity>.toDomainList(): List<Bulletin> = map { it.toDomain() }