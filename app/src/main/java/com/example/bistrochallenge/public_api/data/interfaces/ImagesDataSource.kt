package com.example.bistrochallenge.public_api.data.interfaces

interface ImagesDataSource {
    suspend fun getRandomImage(): String
}