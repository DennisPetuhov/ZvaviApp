package ge.avalanche.zvavi.bulletin.data.usecase

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse
import ge.avalanche.zvavi.foundation.response.onError
import ge.avalanche.zvavi.foundation.response.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow

class GetBulletinUseCase(
    private val repository: BulletinRepository
) {
    private val logger = Logger.withTag("GetBulletinUseCase")

    fun execute(): Flow<ApiResponse<List<Bulletin>>> = flow {
        emptyFlow<ApiResponse<List<Bulletin>>>()

    }
}
