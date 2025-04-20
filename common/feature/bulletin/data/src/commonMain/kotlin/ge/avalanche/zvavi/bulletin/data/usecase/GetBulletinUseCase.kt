package ge.avalanche.zvavi.bulletin.data.usecase

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBulletinUseCase(
    private val repository: BulletinRepository
) {
    fun execute(): Flow<Result<List<Bulletin>>> = flow {
        try {
            val response = repository.getBulletin()
            when (response) {
                is ApiResponse.Success -> {
                    if (response.data.isNotEmpty()) {
                        emit(Result.success(response.data))
                    } else {
                        emit(Result.failure(Exception("No bulletin data available")))
                    }
                }
                is ApiResponse.Error -> {
                    emit(Result.failure(Exception("Failed to get bulletins: ${response.message}")))
                }
                is ApiResponse.Loading -> {
                    // Do nothing, wait for the actual response
                }
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
