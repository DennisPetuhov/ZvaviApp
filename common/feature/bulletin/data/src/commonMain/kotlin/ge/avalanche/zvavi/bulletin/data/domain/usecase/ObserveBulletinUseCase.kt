package ge.avalanche.zvavi.bulletin.data.domain.usecase

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.bulletin.api.models.BulletinRepository
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class ObserveBulletinUseCase(
    private val repository: BulletinRepository,
    private val dispatchers: DispatchersProvider
) {
    private val logger = Logger.Companion.withTag("ObserveBulletinUseCase")

    suspend fun execute(): Flow<Bulletin> {
        logger.d { "Executing ObserveBulletinUseCase" }
        return repository.observeBulletin()
            .flowOn(dispatchers.io)
    }
} 