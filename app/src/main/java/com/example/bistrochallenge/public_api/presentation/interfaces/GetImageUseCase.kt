package com.example.bistrochallenge.public_api.presentation.interfaces

interface GetImageUseCase {
    suspend fun invoke(): String
}