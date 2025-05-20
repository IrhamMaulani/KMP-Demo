package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.screen.detail.DetailScreen
import org.example.project.screen.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(viewModel: AppViewModel = viewModel { AppViewModel() }) {
    MaterialTheme {
        Surface {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = HomeScreenDestination) {
                composable<HomeScreenDestination> {
                    HomeScreen(
                        modifier = Modifier,
                        navigateToDetail = { navController.navigate(DetailScreenDestination) })
                }
                composable<DetailScreenDestination> {
                    DetailScreen(modifier = Modifier)
                }
            }
        }
    }
}