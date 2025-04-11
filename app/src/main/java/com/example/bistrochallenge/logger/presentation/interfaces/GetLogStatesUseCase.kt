package com.example.bistrochallenge.logger.presentation.interfaces

import com.example.bistrochallenge.logger.domain.LifecycleEvent

interface GetLogStatesUseCase {
    suspend operator fun invoke(): List<LifecycleEvent>
}