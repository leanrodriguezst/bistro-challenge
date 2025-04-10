package com.example.bistrochallenge.factorial.di

import com.example.bistrochallenge.factorial.presentation.interfaces.CalculateFactorialUseCase
import com.example.bistrochallenge.factorial.usecases.CalculateFactorialUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object FactorialModule {

    @Provides
    fun provideCalculateFactorialUseCase(): CalculateFactorialUseCase = CalculateFactorialUseCaseImpl()

}