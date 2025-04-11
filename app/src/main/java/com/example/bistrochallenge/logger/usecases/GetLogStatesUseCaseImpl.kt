package com.example.bistrochallenge.logger.usecases

import com.example.bistrochallenge.logger.domain.LifecycleEvent
import com.example.bistrochallenge.logger.presentation.interfaces.GetLogStatesUseCase
import com.example.bistrochallenge.logger.usecases.interfaces.LoggerRepository
import javax.inject.Inject

class GetLogStatesUseCaseImpl @Inject constructor(
    private val _loggerRepository: LoggerRepository
): GetLogStatesUseCase {
    override suspend fun invoke(): List<LifecycleEvent> {
        return _loggerRepository.getLogStates()
    }
}