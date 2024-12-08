package com.example.workoutwise.model

// Define your Workout data class
data class Workout(
    val name: String,
    val type: String,
    val duration: Int, // Duration in minutes
    val equipmentNeeded: String,
    val description: String
)