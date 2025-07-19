package ge.avalanche.zvavi.bulletin.data.domain.mapper

import ge.avalanche.zvavi.bulletin.api.models.Aspects
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblemType
import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.bulletin.api.models.HazardLevels
import ge.avalanche.zvavi.bulletin.api.models.RecentAvalanches
import ge.avalanche.zvavi.bulletin.api.models.TimeOfDay
import ge.avalanche.zvavi.bulletin.api.models.Trend
import ge.avalanche.zvavi.database.entities.AspectsEntity
import ge.avalanche.zvavi.database.entities.AvalancheProblemEntity
import ge.avalanche.zvavi.database.entities.AvalancheProblemTypeEntity
import ge.avalanche.zvavi.database.entities.AvalancheRiskLevelEntity
import ge.avalanche.zvavi.database.entities.BulletinEntity
import ge.avalanche.zvavi.database.entities.HazardLevelsEntity
import ge.avalanche.zvavi.database.entities.RecentAvalanchesEntity
import ge.avalanche.zvavi.database.entities.TimeOfDayEntity
import ge.avalanche.zvavi.database.entities.TrendEntity
import ge.avalanche.zvavi.network.models.BulletinApi
import ge.avalanche.zvavi.network.models.HazardLevelsApi
import ge.avalanche.zvavi.network.models.addproblems.AspectsApi
import ge.avalanche.zvavi.network.models.addproblems.TimeOfDayApi
import ge.avalanche.zvavi.network.models.problems.AvalancheProblemApi
import ge.avalanche.zvavi.network.models.problems.AvalancheProblemResponse
import ge.avalanche.zvavi.network.models.recentAvalanches.RecentAvalancheResponse
import ge.avalanche.zvavi.network.models.recentAvalanches.RecentAvalanchesApi

/**
 * Maps [BulletinApi] to [BulletinEntity]
 * @return [BulletinEntity] with mapped data from API response
 */
fun BulletinApi.toEntity(): BulletinEntity = BulletinEntity(
    createdAt = bulletinResponse.data.createdAt,
    forecaster = bulletinResponse.data.forecaster,
    status = bulletinResponse.data.status,
    validUntil = bulletinResponse.data.validUntil,
    snowpack = bulletinResponse.data.snowpack,
    summary = bulletinResponse.data.summary,
    weather = bulletinResponse.data.weather,
    snowCondition = bulletinResponse.data.snowCondition,
    additionalHazards = bulletinResponse.data.additionalHazards,
    hazardLevels = bulletinResponse.data.hazardLevels.toEntity(),
    avalancheProblems = avalancheProblemsResponse.toAvalancheProblemEntity(),
    recentAvalanches = recentAvalanchesResponse.toRecentAvalancheEntity()
)

/**
 * Maps [AvalancheProblemApi] to [AvalancheProblemEntity]
 * @return [AvalancheProblemEntity] with mapped data from API response
 */
fun AvalancheProblemApi.toEntity(): AvalancheProblemEntity = AvalancheProblemEntity(
    aspects = aspects.toEntity(),
    avalancheSize = avalancheSize,
    confidence = confidence.toReadableFormat(),
    createdAt = createdAt.toReadableFormat(),
    description = description,
    distribution = distribution.toReadableFormat().toDistributionMap(),
    sensitivity = sensitivity.toReadableFormat().toSensitivityMap(),
    timeOfDay = timeOfDay.toEntity(isAllDay),
    trend = trend.toTrendEntity(),
    type = type.toAvalancheProblemTypeEntity()
)

private fun String.toTrendEntity(): TrendEntity {
    return when (this.lowercase()) {
        "improving" -> TrendEntity.IMPROVING
        "deteriorating" -> TrendEntity.DETERIORATING
        "nochanges" -> TrendEntity.NO_CHANGES
        else -> TrendEntity.NO_CHANGES
    }
}

private fun String.toAvalancheProblemTypeEntity(): AvalancheProblemTypeEntity {
    return AvalancheProblemTypeEntity.fromString(this)
}

private fun String.toDistributionMap(): Map<String, Int> {
    val distribution = mapOf<String, Int>(
        "Widespread" to 80,
        "Specific" to 50,
        "Isolated" to 20
    )
    return distribution.filterKeys { distribution -> distribution in this }
}

private fun String.toReadableFormat() = this.replace(Regex("(?<=[a-z])(?=[A-Z])"), " ")
    .split(" ")
    .joinToString(" ") { word ->
        if (word == this.replace(Regex("(?<=[a-z])(?=[A-Z])"), " ").split(" ").first()) {
            word.replaceFirstChar { it.uppercase() }
        } else {
            word.lowercase()
        }
    }

private fun String.toSensitivityMap(): Map<String, Int> {
    val sensitivity = mapOf<String, Int>(
        "Touchy" to 80,
        "Reactive" to 60,
        "Stubborn" to 40,
        "Unreactive" to 20,
        "Dormant" to 20
    )
    return sensitivity.filterKeys { sensitivity -> sensitivity in this }
}

/**
 * Maps [AspectsApi] to [AspectsEntity]
 * @return [AspectsEntity] with mapped data from API response
 */
fun AspectsApi.toEntity(): AspectsEntity = AspectsEntity(
    alpine = alpine.toAspectsEntity(),
    highAlpine = highAlpine.toAspectsEntity(),
    subAlpine = subAlpine.toAspectsEntity()
)

/**
 * Converts a list of aspect strings to a map of aspect directions and their corresponding numeric values.
 * Only includes aspects that are present in the input list.
 *
 * @return Map<String, Int> where:
 * - Key: Aspect direction ("n", "ne", "e", "es", "s", "sw", "w", "nw")
 * - Value: Numeric representation of the aspect (1-8)
 */
private fun List<String>.toAspectsEntity(): Map<String, Int> {
    val aspectMap: Map<String, Int> = mapOf(
        "n" to 6,
        "ne" to 7,
        "e" to 8,
        "es" to 1,
        "s" to 2,
        "sw" to 3,
        "w" to 4,
        "nw" to 5
    )
    return aspectMap.filterKeys { aspect -> aspect in this }
}

/**
 * Maps [TimeOfDayApi] to [TimeOfDayEntity]
 * @return [TimeOfDayEntity] with mapped data from API response
 */
private fun TimeOfDayApi.toEntity(isAllDay: Boolean): TimeOfDayEntity = TimeOfDayEntity(
    isAllDay = isAllDay,
    end = end?.formatHour()?.toInt() ?: 0,
    start = start?.formatHour()?.toInt() ?: 0
)

/**
 * Maps [RecentAvalanchesApi] to [RecentAvalanchesEntity]
 * @return [RecentAvalanchesEntity] with mapped data from API response
 */
private fun RecentAvalanchesApi.toEntity(): RecentAvalanchesEntity = RecentAvalanchesEntity(
    aspects = aspects.toEntity(),
    date = date,
    description = description,
    size = size
)

/**
 * Maps [HazardLevelsApi] to [HazardLevelsEntity]
 * @return [HazardLevelsEntity] with mapped data from API response
 */
private fun HazardLevelsApi.toEntity(): HazardLevelsEntity = HazardLevelsEntity(
    alpine = stringToAvalancheRiskLevel(alpine),
    overall = stringToAvalancheRiskLevel(overall),
    subAlpine = stringToAvalancheRiskLevel(subAlpine),
    highAlpine = stringToAvalancheRiskLevel(highAlpine)
)

/**
 * Converts a string value to [AvalancheRiskLevelEntity] enum
 * @param value The string value to convert
 * @return The corresponding [AvalancheRiskLevelEntity] enum value
 */
private fun stringToAvalancheRiskLevel(value: String): AvalancheRiskLevelEntity {
    return when (value) {
        "0" -> AvalancheRiskLevelEntity.NO_INFO
        "1" -> AvalancheRiskLevelEntity.LOW
        "2" -> AvalancheRiskLevelEntity.MODERATE
        "3" -> AvalancheRiskLevelEntity.CONSIDERABLE
        "4" -> AvalancheRiskLevelEntity.HIGH
        "5" -> AvalancheRiskLevelEntity.EXTREME
        else -> AvalancheRiskLevelEntity.NO_INFO
    }
}

/**
 * Maps list of [AvalancheProblemResponse] to list of [AvalancheProblemEntity]
 * @return List of [AvalancheProblemEntity] with mapped data from API responses
 */
private fun List<AvalancheProblemResponse>.toAvalancheProblemEntity(): List<AvalancheProblemEntity> =
    map { it.data.toEntity() }

/**
 * Maps list of [RecentAvalancheResponse] to list of [RecentAvalanchesEntity]
 * @return List of [RecentAvalanchesEntity] with mapped data from API responses
 */
private fun List<RecentAvalancheResponse>.toRecentAvalancheEntity(): List<RecentAvalanchesEntity> =
    map { it.data.toEntity() }

/**
 * Maps [BulletinEntity] to [Bulletin] domain model
 * @return [Bulletin] with mapped data from entity
 */
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
    hazardLevels = hazardLevels.toDomain(),
    avalancheProblems = avalancheProblems.toAvalancheProblemDomainList,
    recentAvalanches = recentAvalanches.toRecentAvalanchesDomainList
)

/**
 * Maps [HazardLevelsEntity] to [HazardLevels] domain model
 * @return [HazardLevels] with mapped data from entity
 */
private fun HazardLevelsEntity.toDomain(): HazardLevels = HazardLevels(
    alpine = alpine.toDomain(),
    overall = overall.toDomain(),
    subAlpine = subAlpine.toDomain(),
    highAlpine = highAlpine.toDomain()
)

/**
 * Maps [AvalancheRiskLevelEntity] to [AvalancheRiskLevel] domain model
 * @return [AvalancheRiskLevel] with mapped data from entity
 */
private fun AvalancheRiskLevelEntity.toDomain(): AvalancheRiskLevel {
    return AvalancheRiskLevel.entries.find { it.value == this.value } ?: AvalancheRiskLevel.NO_INFO
}

/**
 * Maps [AvalancheProblemEntity] to [AvalancheProblem] domain model
 * @return [AvalancheProblem] with mapped data from entity
 */
private fun AvalancheProblemEntity.toDomain(): AvalancheProblem = AvalancheProblem(
    aspects = aspects.toDomain(),
    avalancheSize = avalancheSize,
    confidence = confidence,
    createdAt = createdAt,
    description = description,
    distribution = distribution,
    sensitivity = sensitivity,
    timeOfDay = timeOfDay.toDomain(),
    trend = trend.toDomain(),
    type = type.toDomain()
)

private fun TrendEntity.toDomain(): Trend {
    return when (this) {
        TrendEntity.IMPROVING -> Trend.IMPROVING
        TrendEntity.DETERIORATING -> Trend.DETERIORATING
        TrendEntity.NO_CHANGES -> Trend.NO_CHANGES
    }
}

private fun AvalancheProblemTypeEntity.toDomain(): AvalancheProblemType {
    return when (this) {
        is AvalancheProblemTypeEntity.WindSlab -> AvalancheProblemType.WindSlab
        is AvalancheProblemTypeEntity.WetSlab -> AvalancheProblemType.WetSlab
        is AvalancheProblemTypeEntity.LooseDry -> AvalancheProblemType.LooseDry
        is AvalancheProblemTypeEntity.LooseWet -> AvalancheProblemType.LooseWet
        is AvalancheProblemTypeEntity.PersistentSlab -> AvalancheProblemType.PersistentSlab
        is AvalancheProblemTypeEntity.StormSlab -> AvalancheProblemType.StormSlab
        is AvalancheProblemTypeEntity.Cornice -> AvalancheProblemType.Cornice
        is AvalancheProblemTypeEntity.Glide -> AvalancheProblemType.Glide
        is AvalancheProblemTypeEntity.DeepSlab -> AvalancheProblemType.DeepSlab
        is AvalancheProblemTypeEntity.Unknown -> AvalancheProblemType.Unknown(this.unknownValue)
    }
}

/**
 * Maps [AspectsEntity] to [Aspects] domain model
 * @return [Aspects] with mapped data from entity
 */
fun AspectsEntity.toDomain(): Aspects = Aspects(
    alpine = alpine,
    highAlpine = highAlpine,
    subAlpine = subAlpine
)

/**
 * Maps [TimeOfDayEntity] to [TimeOfDay] domain model
 * @return [TimeOfDay] with mapped data from entity
 */
private fun TimeOfDayEntity.toDomain(): TimeOfDay = TimeOfDay(
    isAllDay = isAllDay,
    end = end,
    start = start
)

/**
 * Maps [RecentAvalanchesEntity] to [RecentAvalanches] domain model
 * @return [RecentAvalanches] with mapped data from entity
 */
private fun RecentAvalanchesEntity.toDomain(): RecentAvalanches = RecentAvalanches(
    aspects = aspects.toDomain(),
    date = date,
    description = description,
    size = size
)

/**
 * Extension property to map list of [AvalancheProblemEntity] to list of [AvalancheProblem]
 */
private val List<AvalancheProblemEntity>.toAvalancheProblemDomainList: List<AvalancheProblem>
    get() = map { it.toDomain() }

/**
 * Extension property to map list of [RecentAvalanchesEntity] to list of [RecentAvalanches]
 */
private val List<RecentAvalanchesEntity>.toRecentAvalanchesDomainList: List<RecentAvalanches>
    get() = map { it.toDomain() }

/**
 * Formats ISO 8601 date string to extract and round up hours
 * @param dateString ISO 8601 date string (e.g. "2025-04-10T06:00:00.606Z")
 * @return Formatted hour string (e.g. "7" for "2025-04-10T06:30:00.606Z")
 */
private fun String.formatHour(): String {
    return try {
        val hour = this.substringAfter("T").substringBefore(":").toInt()
        val minutes = this.substringAfter(":").substringBefore(":").toInt()
        (if (minutes >= 30) hour + 1 else hour).toString()
    } catch (e: Exception) {
        ""
    }
}