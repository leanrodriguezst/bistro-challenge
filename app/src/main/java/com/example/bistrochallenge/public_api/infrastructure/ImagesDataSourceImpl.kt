package com.example.bistrochallenge.public_api.infrastructure

import com.example.bistrochallenge.public_api.data.interfaces.ImagesDataSource
import com.example.bistrochallenge.public_api.infrastructure.interfaces.ImagesService
import javax.inject.Inject

class ImagesDataSourceImpl @Inject constructor(
    private val _apiService: ImagesService
) : ImagesDataSource {
    override suspend fun getRandomImage(): String {
        try {
            val response = _apiService.getRandomImage()
            val message = response.message
            return message
        } catch (e: Exception) {
            throw e
        }
    }
}