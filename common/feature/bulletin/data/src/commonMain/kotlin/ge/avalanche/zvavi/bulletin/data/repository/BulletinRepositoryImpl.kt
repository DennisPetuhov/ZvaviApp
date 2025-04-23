package ge.avalanche.zvavi.bulletin.data.repository

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.foundation.base.BaseRepository
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import ge.avalanche.zvavi.foundation.response.ApiResponse

class BulletinRepositoryImpl(
    private val remoteDataSource: BulletinRemoteDataSource,
    dispatchers: DispatchersProvider
) : BaseRepository(dispatchers, Logger.withTag("BulletinRepository")), BulletinRepository {
    override suspend fun getBulletin(): ApiResponse<List<Bulletin>> =
        safeApiCallWithIo("Failed to get bulletins") {
            remoteDataSource.getBulletin()
        } ?: ApiResponse.Error(0, "Failed to get bulletin")
}