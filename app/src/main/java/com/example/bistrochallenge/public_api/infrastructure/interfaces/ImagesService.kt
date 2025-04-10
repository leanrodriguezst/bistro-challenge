package com.example.bistrochallenge.public_api.infrastructure.interfaces

import com.example.bistrochallenge.public_api.infrastructure.models.DogNetwork
import retrofit2.http.GET

interface ImagesService {

    @GET("breeds/image/random")
    suspend fun getRandomImage(): DogNetwork

}