package com.example.bistrochallenge.logger.infrastructure.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bistrochallenge.logger.infrastructure.models.LifecycleEventRoom

@Dao
interface LifecycleEventDao {

    @Insert
    suspend fun insert(event: LifecycleEventRoom)

    @Query("SELECT * FROM lifecycle_events ORDER BY timestamp DESC")
    suspend fun getAllEvents(): List<LifecycleEventRoom>

}