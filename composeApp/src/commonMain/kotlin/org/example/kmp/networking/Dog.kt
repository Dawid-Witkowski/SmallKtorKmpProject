package org.example.kmp.networking

import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    val message: String,
    val status: String
)