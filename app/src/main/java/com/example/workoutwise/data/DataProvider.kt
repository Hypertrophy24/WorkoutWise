// DataProvider.kt
package com.example.workoutwise.data

import com.example.workoutwise.model.Meal
import com.example.workoutwise.model.Workout
import com.example.workoutwise.model.Exercise

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
            )
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
            )
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
            )
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
            )
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
            )
        ),
        Workout(
            name = "Cycling",
            type = "Cardio",
            duration = 50,
            equipmentNeeded = "Bicycle",
            description = "Enhance your cardiovascular fitness with a steady cycling session.",
            exercises = listOf(
                Exercise(
                    name = "Warm-Up Ride",
                    duration = "10 minutes"
                ),
                Exercise(
                    name = "Hill Climbs",
                    duration = "20 minutes"
                ),
                Exercise(
                    name = "Interval Sprints",
                    duration = "15 minutes"
                ),
                Exercise(
                    name = "Cool-Down Ride",
                    duration = "5 minutes"
                )
            )
        ),
        Workout(
            name = "Bodyweight Circuit",
            type = "Strength",
            duration = 30,
            equipmentNeeded = "None",
            description = "A quick bodyweight circuit to build strength and endurance.",
            exercises = listOf(
                Exercise(
                    name = "Push-Ups",
                    repetitions = "3 sets of 15 reps"
                ),
                Exercise(
                    name = "Squats",
                    repetitions = "3 sets of 20 reps"
                ),
                Exercise(
                    name = "Plank",
                    duration = "3 sets of 60 seconds"
                ),
                Exercise(
                    name = "Lunges",
                    repetitions = "3 sets of 12 reps each leg"
                )
            )
        ),
        Workout(
            name = "Pilates Core",
            type = "Flexibility",
            duration = 35,
            equipmentNeeded = "Pilates Mat",
            description = "Focus on strengthening your core with Pilates exercises.",
            exercises = listOf(
                Exercise(
                    name = "Roll Over",
                    repetitions = "10 reps"
                ),
                Exercise(
                    name = "Double Leg Stretch",
                    repetitions = "15 reps"
                ),
                Exercise(
                    name = "Teaser",
                    repetitions = "10 reps"
                ),
                Exercise(
                    name = "Swimming",
                    duration = "60 seconds"
                )
            )
        ),
        Workout(
            name = "Kickboxing",
            type = "Cardio",
            duration = 40,
            equipmentNeeded = "Boxing Gloves",
            description = "Improve your coordination and burn calories with kickboxing.",
            exercises = listOf(
                Exercise(
                    name = "Jab-Cross Combo",
                    duration = "5 minutes"
                ),
                Exercise(
                    name = "Roundhouse Kicks",
                    duration = "10 minutes"
                ),
                Exercise(
                    name = "Uppercuts",
                    duration = "10 minutes"
                ),
                Exercise(
                    name = "Cool-Down Stretches",
                    duration = "15 minutes"
                )
            )
        ),
        Workout(
            name = "TRX Suspension Training",
            type = "Strength",
            duration = 50,
            equipmentNeeded = "TRX Bands",
            description = "Utilize suspension straps to perform full-body strength exercises.",
            exercises = listOf(
                Exercise(
                    name = "TRX Rows",
                    repetitions = "3 sets of 12 reps"
                ),
                Exercise(
                    name = "TRX Chest Press",
                    repetitions = "3 sets of 10 reps"
                ),
                Exercise(
                    name = "TRX Lunges",
                    repetitions = "3 sets of 15 reps each leg"
                ),
                Exercise(
                    name = "TRX Plank",
                    duration = "3 sets of 60 seconds"
                )
            )
        ),
        Workout(
            name = "Swimming Laps",
            type = "Cardio",
            duration = 45,
            equipmentNeeded = "Swimsuit, Goggles",
            description = "Improve your cardiovascular health and muscle tone by swimming laps.",
            exercises = listOf(
                Exercise(
                    name = "Freestyle Laps",
                    duration = "20 minutes"
                ),
                Exercise(
                    name = "Breaststroke Laps",
                    duration = "15 minutes"
                ),
                Exercise(
                    name = "Backstroke Laps",
                    duration = "10 minutes"
                )
            )
        ),
        Workout(
            name = "Tai Chi",
            type = "Flexibility",
            duration = 60,
            equipmentNeeded = "Comfortable Clothing",
            description = "Enhance your balance and flexibility with Tai Chi movements.",
            exercises = listOf(
                Exercise(
                    name = "Commencing Form",
                    duration = "10 minutes"
                ),
                Exercise(
                    name = "Grasp the Bird's Tail",
                    duration = "20 minutes"
                ),
                Exercise(
                    name = "Single Whip",
                    duration = "15 minutes"
                ),
                Exercise(
                    name = "Closing Form",
                    duration = "15 minutes"
                )
            )
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
        ),
        Meal(
            name = "Quinoa Salad",
            mealType = "Lunch",
            calories = 400,
            ingredients = listOf("Quinoa", "Cherry Tomatoes", "Cucumbers", "Feta Cheese", "Olive Oil", "Lemon Juice"),
            recipe = "Cook quinoa as per instructions. Mix with chopped vegetables, feta cheese, olive oil, and lemon juice."
        ),
        Meal(
            name = "Chicken Stir-Fry",
            mealType = "Dinner",
            calories = 500,
            ingredients = listOf("Chicken Breast", "Bell Peppers", "Broccoli", "Soy Sauce", "Garlic", "Ginger"),
            recipe = "Sauté chicken with garlic and ginger. Add vegetables and soy sauce, cook until tender."
        ),
        Meal(
            name = "Protein Smoothie",
            mealType = "Snack",
            calories = 200,
            ingredients = listOf("Protein Powder", "Banana", "Almond Milk", "Spinach", "Peanut Butter"),
            recipe = "Blend all ingredients until smooth."
        ),
        Meal(
            name = "Omelette",
            mealType = "Breakfast",
            calories = 300,
            ingredients = listOf("Eggs", "Spinach", "Mushrooms", "Cheddar Cheese", "Salt", "Pepper"),
            recipe = "Beat eggs and pour into a heated pan. Add vegetables and cheese, fold when cooked."
        ),
        Meal(
            name = "Beef Tacos",
            mealType = "Dinner",
            calories = 450,
            ingredients = listOf("Ground Beef", "Taco Shells", "Lettuce", "Tomatoes", "Cheddar Cheese", "Salsa"),
            recipe = "Cook ground beef with taco seasoning. Fill shells with beef and toppings."
        ),
        Meal(
            name = "Greek Yogurt Parfait",
            mealType = "Breakfast",
            calories = 180,
            ingredients = listOf("Greek Yogurt", "Granola", "Honey", "Berries"),
            recipe = "Layer Greek yogurt with granola and berries. Drizzle honey on top."
        ),
        Meal(
            name = "Hummus and Veggie Wrap",
            mealType = "Lunch",
            calories = 350,
            ingredients = listOf("Whole Wheat Wrap", "Hummus", "Carrots", "Cucumbers", "Bell Peppers", "Spinach"),
            recipe = "Spread hummus on wrap, add sliced vegetables and spinach, then roll up."
        ),
        Meal(
            name = "Shrimp Pasta",
            mealType = "Dinner",
            calories = 550,
            ingredients = listOf("Shrimp", "Whole Wheat Pasta", "Garlic", "Olive Oil", "Cherry Tomatoes", "Parmesan Cheese"),
            recipe = "Cook pasta as per instructions. Sauté shrimp with garlic and olive oil, add tomatoes, mix with pasta, and sprinkle cheese."
        ),
        Meal(
            name = "Fruit Salad",
            mealType = "Snack",
            calories = 150,
            ingredients = listOf("Strawberries", "Blueberries", "Kiwi", "Mango", "Orange Juice"),
            recipe = "Chop all fruits and mix in a bowl. Drizzle with orange juice."
        ),
        Meal(
            name = "Turkey Sandwich",
            mealType = "Lunch",
            calories = 400,
            ingredients = listOf("Whole Grain Bread", "Turkey Slices", "Lettuce", "Tomato", "Mustard"),
            recipe = "Assemble turkey slices with lettuce and tomato between bread slices. Spread mustard as desired."
        )
        // Add more meals as needed
    )
}
