package com.example.bistrochallenge.public_api.usecases

import com.example.bistrochallenge.public_api.presentation.interfaces.GetImageUseCase
import com.example.bistrochallenge.public_api.usecases.interfaces.ImagesRepository
import javax.inject.Inject

class GetImageUseCaseImpl @Inject constructor(
    private val _imagesRepository: ImagesRepository
) : GetImageUseCase {
    override suspend fun invoke(): String {
        val response = _imagesRepository.getRandomImage()
        return response
    }
}