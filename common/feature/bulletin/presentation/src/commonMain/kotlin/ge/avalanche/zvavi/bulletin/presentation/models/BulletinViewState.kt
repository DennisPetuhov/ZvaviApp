package ge.avalanche.zvavi.bulletin.presentation.models

data class BulletinViewState(
    val emailValue: String = "",
    val passwordValue: String = "",
    val riskLevelOverall: String = "",
    val overallInformation: String = "",
    val travelAdvice: String = "",
    val riskLevelHighAlpine: String = "",
    val riskLevelAlpine: String = "",
    val riskLevelSubAlpine: String = "",
    val problems: List<String> = emptyList(),
    val recentAvalanches: List<String> = emptyList(),
    val snowpack: String = "WOWOWO",
    val weather: String = "WOWOWOOWOWOWO",
    val loading: Boolean = false,
    val error: String? = null
) {
    companion object {
        val EMPTY = BulletinViewState()
    }
}
