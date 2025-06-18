package ge.avalanche.zvavi.bulletin.api.models

import kotlinx.serialization.Serializable

@Serializable
sealed class AvalancheProblemType(val value: String) {
    @Serializable
    object WindSlab : AvalancheProblemType("Wind Slab")

    @Serializable
    object WetSlab : AvalancheProblemType("Wet Slab")

    @Serializable
    object LooseDry : AvalancheProblemType("Dry Loose")

    @Serializable
    object LooseWet : AvalancheProblemType("Wet loose")

    @Serializable
    object PersistentSlab : AvalancheProblemType("Persistent Slab")

    @Serializable
    object StormSlab : AvalancheProblemType("Storm Slab")

    @Serializable
    object Cornice : AvalancheProblemType("Cornice Fall")

    @Serializable
    object Glide : AvalancheProblemType("Glide Avalanche")

    @Serializable
    object DeepSlab : AvalancheProblemType("Deep Persistent Slab")

    @Serializable
    data class Unknown(val unknownValue: String) : AvalancheProblemType(unknownValue)
}