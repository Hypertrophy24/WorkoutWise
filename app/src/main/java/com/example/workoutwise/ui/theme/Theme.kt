// Theme.kt
package com.example.workoutwise.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = GreenPrimary,
    onPrimary = OnGreenPrimary,
    secondary = GreenSecondary,
    onSecondary = OnGreenSecondary,
    background = BlackBackground,
    onBackground = OnBlackBackground,
    surface = DarkSurface,
    onSurface = OnDarkSurface,
    error = Error,
    onError = OnError
)

@Composable
fun WorkoutWiseTheme(
    useDarkTheme: Boolean = true, // Force dark theme
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Use default or customize as needed
        shapes = WorkoutWiseShapes, // Reference the Shapes instance
        content = content
    )
}
