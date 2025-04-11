package com.example.bistrochallenge.logger.infrastructure.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lifecycle_events")
data class LifecycleEventRoom(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val eventName: String,
    val timestamp: Long
)