package ge.avalanche.zvavi.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

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

data class HazardLevelsEntity(
    val alpine: String,
    val overall: String,
    val subAlpine: String,
    val highAlpine: String
)