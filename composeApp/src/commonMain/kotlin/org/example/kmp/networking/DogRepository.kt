package org.example.kmp.networking

interface DogRepository {
    suspend fun getDogImage(): Result<Dog>
}