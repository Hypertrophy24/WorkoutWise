// Workout.kt
package com.example.workoutwise.model

import androidx.annotation.DrawableRes

data class Workout(
    val name: String,
    val type: String,
    val duration: Int, // Duration in minutes
    val equipmentNeeded: String,
    val description: String,
    val exercises: List<Exercise>, // New field for exercises
)
