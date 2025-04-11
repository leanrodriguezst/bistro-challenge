package com.example.bistrochallenge.logger.presentation.interfaces

interface LogStateUseCase {
    suspend fun invoke(
        lifeCycleType: String,
        timestamp: Long
    )
}