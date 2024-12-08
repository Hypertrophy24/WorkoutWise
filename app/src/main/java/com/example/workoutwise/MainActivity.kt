// MainActivity.kt
package com.example.workoutwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.workoutwise.ui.theme.MainScreen
import com.example.workoutwise.ui.theme.WorkoutWiseTheme
import com.example.workoutwise.ui.theme.MainViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutWiseTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}
