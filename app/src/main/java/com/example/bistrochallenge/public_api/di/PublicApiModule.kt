package com.example.bistrochallenge.public_api.di

import com.example.bistrochallenge.public_api.data.ImagesRepositoryImpl
import com.example.bistrochallenge.public_api.data.interfaces.ImagesDataSource
import com.example.bistrochallenge.public_api.infrastructure.ImagesDataSourceImpl
import com.example.bistrochallenge.public_api.infrastructure.interfaces.ImagesService
import com.example.bistrochallenge.public_api.presentation.interfaces.GetImageUseCase
import com.example.bistrochallenge.public_api.usecases.GetImageUseCaseImpl
import com.example.bistrochallenge.public_api.usecases.interfaces.ImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PublicApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): ImagesService = retrofit.create(ImagesService::class.java)


    @Provides
    fun provideImagesDataSource(
        apiService: ImagesService
    ): ImagesDataSource = ImagesDataSourceImpl(
        apiService
    )

    @Provides
    fun provideImagesRepository(
        imagesDataSource: ImagesDataSource
    ): ImagesRepository = ImagesRepositoryImpl(imagesDataSource)

    @Provides
    fun provideGetImageUseCase(imagesRepository: ImagesRepository): GetImageUseCase {
        return GetImageUseCaseImpl(imagesRepository)
    }

}