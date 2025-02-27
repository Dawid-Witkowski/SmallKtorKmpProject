package org.example.kmp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            NavHost(
                navController = rememberNavController(),
                startDestination = "main"
            ) {
                composable("main") {
                    val viewModel = koinViewModel<MainViewModel>()
                    val uiState by viewModel.uiState.collectAsState()
                    val painter = rememberAsyncImagePainter(uiState.dogImageUrl)
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (uiState.isLoading) {
                            Box(
                                modifier = Modifier.size(300.dp), // prevents jumping when loading
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(strokeWidth = 1.dp)
                            }
                        } else {
                            Image(
                                modifier = Modifier.size(300.dp),
                                contentScale = ContentScale.FillBounds,
                                painter = painter,
                                contentDescription = "Dog image",
                            )
                        }
                        Button(onClick = { viewModel.getDogImage() }) {
                            Text("get dawg")
                        }
                        if (uiState.isError) {
                            Text(text = "Error getting dog image", color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}