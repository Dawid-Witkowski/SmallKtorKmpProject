package org.example.kmp.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DogRepositoryImpl(
    private val client: HttpClient
): DogRepository {
    override suspend fun getDogImage(): Result<Dog> {
        try {
            val response = client.get(urlString = "https://dog.ceo/api/breeds/image/random")
            return Result.success(response.body<Dog>())
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }
}