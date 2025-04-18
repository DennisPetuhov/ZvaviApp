package ge.avalanche.zvavi.bulletin.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Bulletin(
    val items: ArrayList<BulletinItem>
)