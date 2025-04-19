package ge.avalanche.zvavi.bulletin.api

import ge.avalanche.zvavi.bulletin.api.models.Bulletin

interface BulletinRepository {
    suspend fun getBulletin(): List<Bulletin>
}