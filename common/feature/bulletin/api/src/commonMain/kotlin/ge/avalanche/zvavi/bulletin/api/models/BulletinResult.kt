package ge.avalanche.zvavi.bulletin.api.network.models

sealed class BulletinResult {
    data class Success(val bulletin: Bulletin) : BulletinResult()
    data class Error(val message: String, val code: Int? = null) : BulletinResult()
    data object Loading : BulletinResult()
} 