package org.example.kmp.di

import io.ktor.client.engine.darwin.Darwin
import org.example.kmp.networking.createHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { createHttpClient(Darwin.create()) }
}