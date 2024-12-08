package com.example.workoutwise.data

import com.example.workoutwise.model.Meal
import com.example.workoutwise.model.Workout

object DataProvider {

    val workouts = listOf(
        Workout(
            name = "Morning Yoga",
            type = "Flexibility",
            duration = 30,
            equipmentNeeded = "Yoga Mat",
            description = "A gentle morning yoga routine to start your day."
        ),
        Workout(
            name = "HIIT Cardio",
            type = "Cardio",
            duration = 20,
            equipmentNeeded = "None",
            description = "High-intensity interval training to burn calories quickly."
        ),
        Workout(
            name = "Strength Training",
            type = "Strength",
            duration = 45,
            equipmentNeeded = "Dumbbells",
            description = "Build muscle and strength with targeted weight exercises."
        ),
        Workout(
            name = "Pilates",
            type = "Flexibility",
            duration = 40,
            equipmentNeeded = "Pilates Mat",
            description = "Improve core strength and flexibility with Pilates."
        ),
        Workout(
            name = "Outdoor Run",
            type = "Cardio",
            duration = 60,
            equipmentNeeded = "Running Shoes",
            description = "Boost your cardiovascular health with an outdoor run."
        )
        // Add more workouts as needed
    )

    val meals = listOf(
        Meal(
            name = "Avocado Toast",
            mealType = "Breakfast",
            calories = 250,
            ingredients = listOf("Bread", "Avocado", "Salt", "Pepper"),
            recipe = "Toast the bread and spread mashed avocado on top. Season to taste."
        ),
        Meal(
            name = "Grilled Chicken Salad",
            mealType = "Lunch",
            calories = 350,
            ingredients = listOf("Chicken Breast", "Lettuce", "Tomatoes", "Cucumbers", "Dressing"),
            recipe = "Grill the chicken and mix with vegetables and dressing."
        ),
        // Add more meals as needed
    )
}
