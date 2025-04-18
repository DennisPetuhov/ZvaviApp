package ge.avalanche.zvavi.bulletin.api

import ge.avalanche.zvavi.bulletin.api.models.BulletinItem

interface BulletinRepository {
    suspend fun getBulletin(): List<BulletinItem>
}