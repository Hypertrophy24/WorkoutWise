// DataProvider.kt
package com.example.workoutwise.data

import com.example.workoutwise.model.Meal
import com.example.workoutwise.model.Workout
import com.example.workoutwise.model.Exercise
import com.example.workoutwise.R // Ensure you have the correct drawable resources

object DataProvider {

    val workouts = listOf(
        Workout(
            name = "Morning Yoga",
            type = "Flexibility",
            duration = 30,
            equipmentNeeded = "Yoga Mat",
            description = "A gentle morning yoga routine to start your day.",
            exercises = listOf(
                Exercise(
                    name = "Sun Salutation",
                    repetitions = "5 rounds"
                ),
                Exercise(
                    name = "Downward Dog",
                    duration = "60 seconds"
                ),
                Exercise(
                    name = "Child's Pose",
                    duration = "60 seconds"
                )
            ),

        ),
        Workout(
            name = "HIIT Cardio",
            type = "Cardio",
            duration = 20,
            equipmentNeeded = "None",
            description = "High-intensity interval training to burn calories quickly.",
            exercises = listOf(
                Exercise(
                    name = "Jumping Jacks",
                    duration = "30 seconds"
                ),
                Exercise(
                    name = "Burpees",
                    repetitions = "15 reps"
                ),
                Exercise(
                    name = "High Knees",
                    duration = "30 seconds"
                )
            ),

        ),
        Workout(
            name = "Strength Training",
            type = "Strength",
            duration = 45,
            equipmentNeeded = "Dumbbells",
            description = "Build muscle and strength with targeted weight exercises.",
            exercises = listOf(
                Exercise(
                    name = "Dumbbell Squats",
                    repetitions = "3 sets of 12 reps"
                ),
                Exercise(
                    name = "Bench Press",
                    repetitions = "3 sets of 10 reps"
                ),
                Exercise(
                    name = "Bicep Curls",
                    repetitions = "3 sets of 15 reps"
                )
            ),

        ),
        Workout(
            name = "Pilates",
            type = "Flexibility",
            duration = 40,
            equipmentNeeded = "Pilates Mat",
            description = "Improve core strength and flexibility with Pilates.",
            exercises = listOf(
                Exercise(
                    name = "The Hundred",
                    duration = "60 seconds"
                ),
                Exercise(
                    name = "Roll Up",
                    repetitions = "10 reps"
                ),
                Exercise(
                    name = "Leg Circles",
                    duration = "30 seconds each leg"
                )
            ),

        ),
        Workout(
            name = "Outdoor Run",
            type = "Cardio",
            duration = 60,
            equipmentNeeded = "Running Shoes",
            description = "Boost your cardiovascular health with an outdoor run.",
            exercises = listOf(
                Exercise(
                    name = "Warm-Up Jog",
                    duration = "10 minutes"
                ),
                Exercise(
                    name = "Interval Sprints",
                    duration = "20 minutes (1 min sprint, 1 min walk)"
                ),
                Exercise(
                    name = "Cool-Down Jog",
                    duration = "10 minutes"
                )
            ),
        )
        // Add more workouts with their respective exercises as needed
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
        )
        // Add more meals as needed
    )
}
