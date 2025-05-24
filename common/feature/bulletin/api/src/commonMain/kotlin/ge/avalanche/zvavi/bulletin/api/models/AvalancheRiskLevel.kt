package ge.avalanche.zvavi.bulletin.api.models

enum class AvalancheRiskLevel(val value: Int) {
    NO_INFO(0),
    LOW(1),
    MODERATE(2),
    CONSIDERABLE(3),
    HIGH(4),
    EXTREME(5)
}