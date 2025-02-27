package org.example.kmp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext

class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@KoinApp)
        }
    }
}