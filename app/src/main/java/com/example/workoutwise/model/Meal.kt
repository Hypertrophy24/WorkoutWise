package com.example.workoutwise.model

data class Meal(
    val name: String,
    val mealType: String, // Breakfast, Lunch, Dinner
    val calories: Int,
    val ingredients: List<String>,
    val recipe: String
)
