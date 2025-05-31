package ge.avalanche.zvavi.bulletin.api.models

import kotlinx.serialization.Serializable

data class Bulletin(
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
    val avalancheProblems: List<AvalancheProblem>,
    val recentAvalanches: List<RecentAvalanches>
) {
    companion object {
        val EMPTY = Bulletin(
            id = 0,
            createdAt = "",
            forecaster = "",
            status = "",
            validUntil = "",
            snowpack = "",
            summary = "",
            weather = "",
            snowCondition = "",
            additionalHazards = "",
            hazardLevels = HazardLevels.EMPTY,
            avalancheProblems = emptyList(),
            recentAvalanches = emptyList()
        )
    }
}

data class RecentAvalanches(
    val aspects: Aspects,
    val date: String,
    val description: String,
    val size: Int
)

data class AvalancheProblem(
    val aspects: Aspects,
    val avalancheSize: Int,
    val confidence: String,
    val createdAt: String,
    val description: String,
    val distribution: Map<String, Int>,
    val sensitivity: Map<String, Int>,
    val timeOfDay: TimeOfDay,
    val trend: Trend,
    val type: String
)

/**
 * Represents the trend direction of an avalanche problem.
 */
@Serializable
enum class Trend(val direction: String) {
    /** Problem is improving */
    IMPROVING("Improving"),

    /** Problem is deteriorating */
    DETERIORATING("Deteriorating"),

    /** No significant changes */
    NO_CHANGES("No changes")
}

data class Aspects(
    val alpine: Map<String, Int>,
    val highAlpine: Map<String, Int>,
    val subAlpine: Map<String, Int>,
)

data class TimeOfDay(
    val isAllDay: Boolean,
    val end: String,
    val start: String,
)

enum class AvalancheRiskLevel(val value: Int) {
    NO_INFO(0),
    LOW(1),
    MODERATE(2),
    CONSIDERABLE(3),
    HIGH(4),
    EXTREME(5)
}

@Serializable
data class HazardLevels(
    val alpine: AvalancheRiskLevel,
    val overall: AvalancheRiskLevel,
    val subAlpine: AvalancheRiskLevel,
    val highAlpine: AvalancheRiskLevel,
) {
    companion object {
        val EMPTY = HazardLevels(
            alpine = AvalancheRiskLevel.NO_INFO,
            overall = AvalancheRiskLevel.NO_INFO,
            subAlpine = AvalancheRiskLevel.NO_INFO,
            highAlpine = AvalancheRiskLevel.NO_INFO
        )
    }
}