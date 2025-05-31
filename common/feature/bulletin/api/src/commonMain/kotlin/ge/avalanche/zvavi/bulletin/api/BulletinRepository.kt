package ge.avalanche.zvavi.bulletin.api

import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import kotlinx.coroutines.flow.Flow

interface BulletinRepository {
  suspend  fun  fetchBulletin()
  suspend fun observeBulletin(): Flow<Bulletin>
}