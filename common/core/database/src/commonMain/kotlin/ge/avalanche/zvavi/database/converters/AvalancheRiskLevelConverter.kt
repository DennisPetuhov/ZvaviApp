package ge.avalanche.zvavi.database.converters

import androidx.room.TypeConverter
import ge.avalanche.zvavi.database.entities.AvalancheRiskLevelEntity

/**
 * Type converter for Room to convert between AvalancheRiskLevel enum and Int
 */
class AvalancheRiskLevelConverter {
    @TypeConverter
    fun fromAvalancheRiskLevel(value: AvalancheRiskLevelEntity): Int {
        return value.value
    }

    @TypeConverter
    fun toAvalancheRiskLevel(value: Int): AvalancheRiskLevelEntity {
        return when (value) {
            0 -> AvalancheRiskLevelEntity.GENERAL_INFORMATION
            1 -> AvalancheRiskLevelEntity.LOW
            2 -> AvalancheRiskLevelEntity.MODERATE
            3 -> AvalancheRiskLevelEntity.CONSIDERABLE
            4 -> AvalancheRiskLevelEntity.HIGH
            5 -> AvalancheRiskLevelEntity.EXTREME
            else -> AvalancheRiskLevelEntity.GENERAL_INFORMATION
        }
    }
} 