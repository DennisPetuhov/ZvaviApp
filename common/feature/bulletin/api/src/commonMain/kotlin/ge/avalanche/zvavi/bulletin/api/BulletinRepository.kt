package ge.avalanche.zvavi.bulletin.api

import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse

interface BulletinRepository {
    suspend fun getBulletin(): ApiResponse<List<Bulletin>>
}