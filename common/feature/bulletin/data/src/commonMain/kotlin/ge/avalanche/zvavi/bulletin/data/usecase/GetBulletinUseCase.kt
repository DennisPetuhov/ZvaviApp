package ge.avalanche.zvavi.bulletin.data.usecase

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse
import ge.avalanche.zvavi.foundation.response.onError
import ge.avalanche.zvavi.foundation.response.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBulletinUseCase(
    private val repository: BulletinRepository
) {
    private val logger = Logger.withTag("GetBulletinUseCase")

    fun execute(): Flow<ApiResponse<List<Bulletin>>> = flow {
        emit(ApiResponse.Loading)

        try {
            repository.getBulletin()
                .onSuccess { bulletins ->
                    if (bulletins.isNotEmpty()) {
                        emit(ApiResponse.Success(bulletins, 200))
                    } else {
                        emit(ApiResponse.Error(
                            code = 404,
                            message = "No bulletin data available"
                        ))
                    }
                }
                .onError { code, message, details, exception ->
                    logger.e(exception) { "Failed to get bulletins: $message" }
                    emit(ApiResponse.Error(
                        code = code,
                        message = "Failed to get bulletins: $message",
                        details = details,
                        exception = exception
                    ))
                }
        } catch (e: Exception) {
            logger.e(e) { "Unexpected error in GetBulletinUseCase" }
            emit(ApiResponse.Error(
                code = 500,
                message = "Unexpected error: ${e.message}",
                exception = e
            ))
        }
    }
}
