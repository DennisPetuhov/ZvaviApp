package ge.avalanche.zvavi.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ge.avalanche.zvavi.database.converters.AvalancheRiskLevelConverter

import kotlinx.serialization.Serializable

const val BULLETIN_TABLE = "bulletin"

@Entity(tableName = BULLETIN_TABLE)
@Serializable
data class BulletinEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val createdAt: String,
    val forecaster: String,
    val status: String,
    val validUntil: String,
    val snowpack: String,
    val summary: String,
    val weather: String,
    val snowCondition: String,
    val additionalHazards: String,
    @Embedded(prefix = "hazard_")
    val hazardLevels: HazardLevelsEntity,
    val avalancheProblems: List<AvalancheProblemEntity>,
    val recentAvalanches: List<RecentAvalanchesEntity>
)

@TypeConverters(AvalancheRiskLevelConverter::class)
@Serializable
data class HazardLevelsEntity(
    val alpine: AvalancheRiskLevelEntity,
    val overall: AvalancheRiskLevelEntity,
    val subAlpine: AvalancheRiskLevelEntity,
    val highAlpine: AvalancheRiskLevelEntity
)

@Serializable
data class RecentAvalanchesEntity(
    @Embedded(prefix = "aspects_")
    val aspects: AspectsEntity,
    val date: String,
    val description: String,
    val size: Int
)

@Serializable
data class AvalancheProblemEntity(
    @Embedded(prefix = "aspects_")
    val aspects: AspectsEntity,
    val avalancheSize: Int,
    val confidence: String,
    val createdAt: String,
    val description: String,
    val distribution: Map<String, Int>,
    val sensitivity: Map<String, Int>,
    @Embedded(prefix = "time_of_day_")
    val timeOfDay: TimeOfDayEntity,
    val trend: TrendEntity,
    val type: AvalancheProblemTypeEntity
)

/**
 * Represents the trend direction of an avalanche problem.
 */
@Serializable
enum class TrendEntity(val direction: String) {
    /** Problem is improving */
    IMPROVING("Improving"),

    /** Problem is deteriorating */
    DETERIORATING("Deteriorating"),

    /** No significant changes */
    NO_CHANGES("No changes")
}

@Serializable
data class AspectsEntity(
    val alpine: Map<String, Int>,
    val highAlpine: Map<String, Int>,
    val subAlpine: Map<String, Int>,
)

@Serializable
data class TimeOfDayEntity(
    val isAllDay: Boolean,
    val end: Int,
    val start: Int,
)

@Serializable
enum class AvalancheRiskLevelEntity(val value: Int) {
    NO_INFO(0),
    LOW(1),
    MODERATE(2),
    CONSIDERABLE(3),
    HIGH(4),
    EXTREME(5)
}

@Serializable
sealed class AvalancheProblemTypeEntity{
    @Serializable
    object WindSlab : AvalancheProblemTypeEntity()

    @Serializable
    object WetSlab : AvalancheProblemTypeEntity()

    @Serializable
    object LooseDry : AvalancheProblemTypeEntity()

    @Serializable
    object LooseWet : AvalancheProblemTypeEntity()

    @Serializable
    object PersistentSlab : AvalancheProblemTypeEntity()

    @Serializable
    object StormSlab : AvalancheProblemTypeEntity()

    @Serializable
    object Cornice : AvalancheProblemTypeEntity()

    @Serializable
    object Glide : AvalancheProblemTypeEntity()

    @Serializable
    object DeepSlab : AvalancheProblemTypeEntity()

    @Serializable
    data class Unknown(val unknownValue: String) : AvalancheProblemTypeEntity()

    companion object {
        fun fromString(value: String): AvalancheProblemTypeEntity {
            return when (value.lowercase()) {
                "windslab" -> WindSlab
                "wetslab" -> WetSlab
                "loosedry" -> LooseDry
                "loosewet" -> LooseWet
                "persistentslab" -> PersistentSlab
                "stormslab" -> StormSlab
                "cornice" -> Cornice
                "glide" -> Glide
                "deepslab" -> DeepSlab
                else -> Unknown(value)
            }
        }
    }
}