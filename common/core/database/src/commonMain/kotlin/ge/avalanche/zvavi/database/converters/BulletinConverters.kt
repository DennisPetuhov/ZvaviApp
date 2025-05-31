package ge.avalanche.zvavi.database.converters

import androidx.room.TypeConverter
import ge.avalanche.zvavi.database.entities.AvalancheProblemEntity
import ge.avalanche.zvavi.database.entities.RecentAvalanchesEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class BulletinConverters {
    @TypeConverter
    fun fromAvalancheProblemsList(value: List<AvalancheProblemEntity>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toAvalancheProblemsList(value: String): List<AvalancheProblemEntity> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromRecentAvalanchesList(value: List<RecentAvalanchesEntity>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toRecentAvalanchesList(value: String): List<RecentAvalanchesEntity> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromStringIntMap(value: Map<String, Int>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStringIntMap(value: String): Map<String, Int> {
        return Json.decodeFromString(value)
    }
}