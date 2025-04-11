package com.example.bistrochallenge.logger.infrastructure.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bistrochallenge.logger.infrastructure.interfaces.LifecycleEventDao
import com.example.bistrochallenge.logger.infrastructure.models.LifecycleEventRoom

@Database(entities = [LifecycleEventRoom::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventDao(): LifecycleEventDao
}