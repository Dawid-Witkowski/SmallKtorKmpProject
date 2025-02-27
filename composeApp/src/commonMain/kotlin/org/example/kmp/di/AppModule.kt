package org.example.kmp.di

import org.example.kmp.ui.MainViewModel
import org.example.kmp.networking.DogRepository
import org.example.kmp.networking.DogRepositoryImpl
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val appModule = module {
    single { DogRepositoryImpl(get()) }.bind<DogRepository>()
    viewModelOf(::MainViewModel)
}