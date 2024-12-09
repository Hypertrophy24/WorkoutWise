// WorkoutsScreen.kt
package com.example.workoutwise.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutwise.model.Exercise
import com.example.workoutwise.model.Workout

@Composable
fun WorkoutsScreen(mainViewModel: MainViewModel) {
    // Observe the suggested workout from the ViewModel
    val suggestedWorkout by mainViewModel.suggestedWorkout.collectAsState()

    // State to control the expansion of the workout card
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    // Main container
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Padding around the content
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Suggested Workout",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp)) // Space between title and content

        if (suggestedWorkout != null) {
            // Display the workout card with details
            WorkoutCard(
                workout = suggestedWorkout!!,
                isExpanded = isExpanded,
                onCardClick = {
                    isExpanded = !isExpanded // Toggle expansion state
                }
            )
        } else {
            // Inform the user to fetch weather data first
            Text(
                text = "No workout suggestion available. Please fetch weather first.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun WorkoutCard(workout: Workout, isExpanded: Boolean, onCardClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() } // Make the card clickable
            .animateContentSize() // Animate size changes smoothly
            .padding(8.dp), // Padding around the card
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Card elevation
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(8.dp)) // Space before text

            // Workout Name
            Text(
                text = workout.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp)) // Space between texts

            // Workout Type
            Text(
                text = "Type: ${workout.type}",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(4.dp)) // Small space

            // Workout Duration
            Text(
                text = "Duration: ${workout.duration} minutes",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(4.dp)) // Small space

            // Equipment Needed
            Text(
                text = "Equipment Needed: ${workout.equipmentNeeded}",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp)) // Space before exercises

            // Animated visibility for exercises list
            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Exercises:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp)) // Small space

                    // Iterate through each exercise and display it
                    workout.exercises.forEach { exercise ->
                        ExerciseItem(exercise = exercise)
                        Spacer(modifier = Modifier.height(4.dp)) // Space between exercises
                    }
                }
            }
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp), // Vertical padding for each exercise
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Simple bullet point using a text symbol
        Text(
            text = "•",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 8.dp) // Space between bullet and text
        )

        Column {
            // Exercise Name
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.bodyLarge
            )
            // Optional: Display repetitions if available
            exercise.repetitions?.let { reps ->
                Text(
                    text = reps,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            // Optional: Display duration if available
            exercise.duration?.let { dur ->
                Text(
                    text = dur,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
