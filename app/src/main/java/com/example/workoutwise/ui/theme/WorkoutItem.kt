package com.example.workoutwise.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.workoutwise.model.Workout

@Composable
fun WorkoutItem(workout: Workout) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = workout.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Type: ${workout.type}")
            Text(text = "Duration: ${workout.duration} mins")
            Text(text = "Equipment: ${workout.equipmentNeeded}")
            Text(text = workout.description)
        }
    }
}
