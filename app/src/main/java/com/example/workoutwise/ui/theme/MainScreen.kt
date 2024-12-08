// MainScreen.kt
package com.example.workoutwise.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workoutwise.navigation.Screen

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Weather.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Weather.route) {
                WeatherScreen(mainViewModel)
            }
            composable(Screen.Meals.route) {
                MealsScreen()
            }
            composable(Screen.Workouts.route) {
                WorkoutsScreen(mainViewModel)
            }
        }
    }
}
