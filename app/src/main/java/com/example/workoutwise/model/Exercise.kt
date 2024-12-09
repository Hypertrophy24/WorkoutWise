// Exercise.kt
package com.example.workoutwise.model

data class Exercise(
    val name: String,
    val repetitions: String? = null, // e.g., "3 sets of 12 reps"
    val duration: String? = null     // e.g., "60 seconds"
)
