package ge.avalanche.zvavi.bulletin.data.usecase

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.models.BulletinItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBulletinUseCase(
    private val repository: BulletinRepository
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
    }
}
