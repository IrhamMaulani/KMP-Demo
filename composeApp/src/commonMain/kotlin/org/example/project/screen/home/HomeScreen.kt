package org.example.project.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import demo_kmp.composeapp.generated.resources.Res
import demo_kmp.composeapp.generated.resources.compose_multiplatform
import org.example.project.Greeting
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel { HomeViewModel() },
    modifier: Modifier,
    navigateToDetail: () -> Unit
) {
    val homeUIState by viewModel.homeUIStateFlow.collectAsStateWithLifecycle()
    var showContent by remember { mutableStateOf(false) }

    LaunchedEffect(homeUIState.navigateToDetail) {
        if (homeUIState.navigateToDetail.isNotEmpty()) {
            navigateToDetail()
            viewModel.resetNavigateToDetail()
        }
    }

    Column(
        modifier = Modifier.safeContentPadding().fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(homeUIState.count.toString())
        Button(onClick = { viewModel.setCount(homeUIState.count + 1) }) {
            Text("Count!")
        }
        Button(onClick = { viewModel.setNavigateToDetail(":id") }) {
            Text("Detail!")
        }
        Button(onClick = { showContent = !showContent }) {
            Text("Click me!")
        }
        AnimatedVisibility(showContent) {
            val greeting = remember { Greeting().greet() }
            Column(
                Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }
    }
}