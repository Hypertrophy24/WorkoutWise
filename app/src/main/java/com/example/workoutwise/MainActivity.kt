// MainActivity.kt
package com.example.workoutwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.workoutwise.ui.theme.MainScreen
import com.example.workoutwise.ui.theme.WorkoutWiseTheme
import com.example.workoutwise.ui.theme.MainViewModel
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>() // ViewModel initialization

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutWiseTheme { // Apply custom theme
                MainScreen(mainViewModel)
            }
        }
    }
}
