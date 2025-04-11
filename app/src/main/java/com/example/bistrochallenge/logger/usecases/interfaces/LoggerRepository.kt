package com.example.bistrochallenge.logger.usecases.interfaces

import com.example.bistrochallenge.logger.domain.LifecycleEvent

interface LoggerRepository {
    suspend fun logState(
        lifeCycleType: String,
        timestamp: Long
    )

    suspend fun getLogStates(): List<LifecycleEvent>
}