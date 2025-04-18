package ge.avalanche.zvavi.bulletin.data.usecase

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.models.BulletinItem
import ge.avalanche.zvavi.common.core.foundation.base.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetBulletinUseCase(
    private val repository: BulletinRepository,
    private val dispatchers: DispatchersProvider
) {
    fun execute(): Flow<Result<List<BulletinItem>>> = flow {
        try {
            val bulletins = repository.getBulletin()
            if (bulletins.isNotEmpty()) {
                emit(Result.success(bulletins))
            } else {
                emit(Result.failure(Exception("No bulletin data available")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }.flowOn(dispatchers.io)
}
