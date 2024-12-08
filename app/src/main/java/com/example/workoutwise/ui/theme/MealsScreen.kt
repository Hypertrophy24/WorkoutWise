// MealsScreen.kt
package com.example.workoutwise.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutwise.data.DataProvider
import com.example.workoutwise.ui.MealItem

@Composable
fun MealsScreen() {
    val meals = DataProvider.meals

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Meals",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(meals.size) { index ->
            MealItem(meal = meals[index])
        }
    }
}
