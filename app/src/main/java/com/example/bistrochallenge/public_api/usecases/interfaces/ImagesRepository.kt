package com.example.bistrochallenge.public_api.usecases.interfaces

interface ImagesRepository {
    suspend fun getRandomImage(): String
}