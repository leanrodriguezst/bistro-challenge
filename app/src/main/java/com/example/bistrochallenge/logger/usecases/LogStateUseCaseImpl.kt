package com.example.bistrochallenge.logger.usecases

import com.example.bistrochallenge.logger.presentation.interfaces.LogStateUseCase
import com.example.bistrochallenge.logger.usecases.interfaces.LoggerRepository
import javax.inject.Inject

class LogStateUseCaseImpl @Inject constructor(
    private val _loggerRepository: LoggerRepository
): LogStateUseCase {
    override suspend fun invoke(lifeCycleType: String, timestamp: Long) {
        _loggerRepository.logState(
            lifeCycleType = lifeCycleType,
            timestamp = timestamp
        )
    }
}