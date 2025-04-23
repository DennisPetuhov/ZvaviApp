package ge.avalanche.zvavi.bulletin.api.database.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bulletins")
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
    val hazardLevels: HazardLevelsEntity
)