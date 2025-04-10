package com.example.bistrochallenge.public_api.data

import com.example.bistrochallenge.public_api.data.interfaces.ImagesDataSource
import com.example.bistrochallenge.public_api.usecases.interfaces.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val _imagesDataSource: ImagesDataSource
) : ImagesRepository {
    override suspend fun getRandomImage(): String {
        val response = _imagesDataSource.getRandomImage()
        return response
    }
}