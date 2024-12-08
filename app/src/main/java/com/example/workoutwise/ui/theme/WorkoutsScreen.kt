// WorkoutsScreen.kt
package com.example.workoutwise.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutwise.ui.theme.MainViewModel

@Composable
fun WorkoutsScreen(mainViewModel: MainViewModel) {
    val suggestedWorkout by mainViewModel.suggestedWorkout.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Suggested Workout",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (suggestedWorkout != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = suggestedWorkout!!.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Type: ${suggestedWorkout!!.type}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Duration: ${suggestedWorkout!!.duration} minutes",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Equipment Needed: ${suggestedWorkout!!.equipmentNeeded}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = suggestedWorkout!!.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        } else {
            Text(
                text = "No workout suggestion available. Please fetch weather first.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
