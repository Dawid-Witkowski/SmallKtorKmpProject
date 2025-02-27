package org.example.kmp

import androidx.compose.ui.window.ComposeUIViewController
import org.example.kmp.di.initKoin
import org.example.kmp.ui.App

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }