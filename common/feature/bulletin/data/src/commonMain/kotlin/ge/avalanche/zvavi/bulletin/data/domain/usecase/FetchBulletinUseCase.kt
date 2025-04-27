package ge.avalanche.zvavi.bulletin.data.domain.usecase

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.BulletinRepository
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.withContext

class FetchBulletinUseCase(
    private val repository: BulletinRepository,
    private val dispatchers: DispatchersProvider
) {
    private val logger = Logger.Companion.withTag("GetBulletinUseCase")

    suspend fun execute() {
        logger.d { "Executing GetBulletinUseCase" }
        withContext(dispatchers.io) {
            repository.fetchBulletin()
        }
    }
}