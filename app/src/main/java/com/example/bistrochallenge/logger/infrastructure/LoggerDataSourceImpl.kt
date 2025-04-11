package com.example.bistrochallenge.logger.infrastructure

import com.example.bistrochallenge.logger.data.interfaces.LoggerDataSource
import com.example.bistrochallenge.logger.infrastructure.interfaces.LifecycleEventDao
import com.example.bistrochallenge.logger.infrastructure.models.LifecycleEventRoom
import javax.inject.Inject

class LoggerDataSourceImpl @Inject constructor(
    private val _lifecycleEventDao: LifecycleEventDao
) : LoggerDataSource {
    override suspend fun logState(lifeCycleType: String, timestamp: Long) {
        try {
            val event = LifecycleEventRoom(
                eventName = lifeCycleType,
                timestamp = timestamp
            )
            _lifecycleEventDao.insert(event)
        } catch (e: Exception) {
            // Handle the exception (e.g., log it, rethrow it, etc.)
            e.printStackTrace()
        }
    }

    override suspend fun getLogStates(): List<LifecycleEventRoom> {
        try {
            val events = _lifecycleEventDao.getAllEvents()
            return events ?: emptyList()
        } catch (e: Exception) {
            // Handle the exception (e.g., log it, rethrow it, etc.)
            e.printStackTrace()
            return emptyList()
        }
    }


}