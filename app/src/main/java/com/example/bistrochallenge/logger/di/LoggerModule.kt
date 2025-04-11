package com.example.bistrochallenge.logger.di

import android.content.Context
import androidx.room.Room
import com.example.bistrochallenge.logger.data.LoggerRepositoryImpl
import com.example.bistrochallenge.logger.data.interfaces.LoggerDataSource
import com.example.bistrochallenge.logger.infrastructure.LoggerDataSourceImpl
import com.example.bistrochallenge.logger.infrastructure.db.AppDatabase
import com.example.bistrochallenge.logger.infrastructure.interfaces.LifecycleEventDao
import com.example.bistrochallenge.logger.presentation.interfaces.GetLogStatesUseCase
import com.example.bistrochallenge.logger.presentation.interfaces.LogStateUseCase
import com.example.bistrochallenge.logger.usecases.GetLogStatesUseCaseImpl
import com.example.bistrochallenge.logger.usecases.LogStateUseCaseImpl
import com.example.bistrochallenge.logger.usecases.interfaces.LoggerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideLifecycleEventDao(db: AppDatabase): LifecycleEventDao {
        return db.eventDao()
    }

    @Provides
    fun provideLoggerDataSource(
        lifecycleEventDao: LifecycleEventDao
    ): LoggerDataSource = LoggerDataSourceImpl(lifecycleEventDao)

    @Provides
    fun provideLoggerRepository(
        loggerDataSource: LoggerDataSource
    ): LoggerRepository = LoggerRepositoryImpl(loggerDataSource)

    @Provides
    fun provideGetLogStatesUseCase(
        loggerRepository: LoggerRepository
    ): GetLogStatesUseCase = GetLogStatesUseCaseImpl(loggerRepository)

    @Provides
    fun provideLogStateUseCase(
        loggerRepository: LoggerRepository
    ): LogStateUseCase = LogStateUseCaseImpl(loggerRepository)

}