// NavScreen.kt
package com.example.workoutwise.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.workoutwise.R

sealed class NavScreen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int
) {
    object Weather : NavScreen("weather", R.string.weather, R.drawable.ic_weather)
    object Meals : NavScreen("meals", R.string.meals, R.drawable.ic_meals)
    object Workouts : NavScreen("workouts", R.string.workouts, R.drawable.ic_workouts)
}
