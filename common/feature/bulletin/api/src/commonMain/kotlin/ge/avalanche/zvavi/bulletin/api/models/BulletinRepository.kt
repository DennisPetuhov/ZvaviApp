package ge.avalanche.zvavi.bulletin.api.models

import kotlinx.coroutines.flow.Flow

interface BulletinRepository {
  suspend  fun  fetchBulletin()
  suspend fun observeBulletin(): Flow<Bulletin>
}