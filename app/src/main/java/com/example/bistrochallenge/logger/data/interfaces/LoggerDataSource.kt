package com.example.bistrochallenge.logger.data.interfaces

import com.example.bistrochallenge.logger.infrastructure.models.LifecycleEventRoom

interface LoggerDataSource {
    suspend fun logState(
        lifeCycleType: String,
        timestamp: Long
    )

    suspend fun getLogStates(): List<LifecycleEventRoom>
}