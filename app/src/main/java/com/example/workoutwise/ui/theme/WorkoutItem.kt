// WorkoutItem.kt
package com.example.workoutwise.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutwise.model.Exercise
import com.example.workoutwise.model.Workout

/**
 * Displays a single workout item with expandable details.
 *
 * @param workout The Workout object containing all details.
 */
@Composable
fun WorkoutItem(workout: Workout) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(), // Smooth animation for any content changes
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = workout.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(4.dp)) // Space between name and details

            Text(
                text = "Duration: ${workout.duration} minutes",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Equipment Needed: ${workout.equipmentNeeded}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp)) // Space before description

            // Description with drop-down to show exercises
            var isDescExpanded by rememberSaveable { mutableStateOf(false) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isDescExpanded = !isDescExpanded },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.weight(1f)) // Push icon to end
                Icon(
                    imageVector = if (isDescExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (isDescExpanded) "Collapse Description" else "Expand Description",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            AnimatedVisibility(visible = isDescExpanded) {
                Column(modifier = Modifier.padding(top = 4.dp)) {
                    Text(
                        text = workout.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp)) // Space before exercises
                    Text(
                        text = "Exercises:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    workout.exercises.forEach { exercise ->
                        ExerciseItem(exercise = exercise)
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
            .padding(vertical = 2.dp), // Vertical padding for each exercise
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Bullet Point
        Text(
            text = "•",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(end = 4.dp)
        )

        Column {
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            exercise.repetitions?.let { reps ->
                Text(
                    text = reps,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            exercise.duration?.let { dur ->
                Text(
                    text = dur,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
