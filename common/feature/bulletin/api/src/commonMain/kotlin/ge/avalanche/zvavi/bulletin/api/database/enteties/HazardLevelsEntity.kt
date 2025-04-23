package ge.avalanche.zvavi.bulletin.api.database.enteties

data class HazardLevelsEntity(
    val id: Int = 0,
    val alpine: String,
    val overall: String,
    val subAlpine: String,
    val highAlpine: String
)