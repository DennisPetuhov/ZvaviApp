package ge.avalanche.zvavi.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ge.avalanche.zvavi.database.converters.AvalancheRiskLevelConverter

const val BULLETIN_TABLE = "bulletin"

@Entity(tableName = BULLETIN_TABLE)
data class BulletinEntity(
    @PrimaryKey
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
    @Embedded(prefix = "hazard_")
    val hazardLevels: HazardLevelsEntity
)

@TypeConverters(AvalancheRiskLevelConverter::class)
data class HazardLevelsEntity(
    val alpine: AvalancheRiskLevelEntity,
    val overall: AvalancheRiskLevelEntity,
    val subAlpine: AvalancheRiskLevelEntity,
    val highAlpine: AvalancheRiskLevelEntity
)

enum class AvalancheRiskLevelEntity(val value: Int) {
    GENERAL_INFORMATION(0),
    LOW(1),
    MODERATE(2),
    CONSIDERABLE(3),
    HIGH(4),
    EXTREME(5)
}