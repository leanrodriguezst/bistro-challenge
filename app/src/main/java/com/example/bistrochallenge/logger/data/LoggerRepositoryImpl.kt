package com.example.bistrochallenge.logger.data

import com.example.bistrochallenge.logger.data.interfaces.LoggerDataSource
import com.example.bistrochallenge.logger.domain.LifecycleEvent
import com.example.bistrochallenge.logger.usecases.interfaces.LoggerRepository
import javax.inject.Inject

class LoggerRepositoryImpl @Inject constructor(
    private val _loggerDataSource: LoggerDataSource
) : LoggerRepository {
    override suspend fun logState(lifeCycleType: String, timestamp: Long) {
        _loggerDataSource.logState(
            lifeCycleType = lifeCycleType,
            timestamp = timestamp
        )
    }

    override suspend fun getLogStates(): List<LifecycleEvent> {
        val logStates = _loggerDataSource.getLogStates()
        return logStates.map { logState ->
            LifecycleEvent(
                id = logState.id,
                eventName = logState.eventName,
                timestamp = logState.timestamp
            )
        }
    }
}