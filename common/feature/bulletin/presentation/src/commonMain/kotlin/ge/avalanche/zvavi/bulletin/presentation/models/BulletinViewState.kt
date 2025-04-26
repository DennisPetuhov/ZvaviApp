package ge.avalanche.zvavi.bulletin.presentation.models

import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel

data class BulletinViewState(
    val riskLevelOverall: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val overallInformation: String = "",
    val avalancheRiskLevel: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val travelAdvice: String = "",
    val riskLevelHighAlpine: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val riskLevelAlpine: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val riskLevelSubAlpine: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val problems: List<String> = emptyList(),
    val recentAvalanches: List<String> = emptyList(),
    val snowpack: String = "",
    val weather: String = "",
    val loading: Boolean = false,
    val error: String? = null
) {
    companion object {
        val EMPTY = BulletinViewState()
    }
}

