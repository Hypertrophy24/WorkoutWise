// MealsScreen.kt
package com.example.workoutwise.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutwise.data.DataProvider
import com.example.workoutwise.ui.theme.MealItem

@Composable
fun MealsScreen(mainViewModel: MainViewModel) {
    // Observe the meals list from the DataProvider
    val meals = DataProvider.meals

    // Group meals by their type (e.g., Breakfast, Lunch, Dinner)
    val mealsByType = meals.groupBy { it.mealType }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Optional: Add a header or description at the top
        Text(
            text = "Meals",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between header and list

        // Main Meals List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Space between categories
        ) {
            mealsByType.forEach { (type, mealsList) ->
                // Category Header with drop-down functionality
                item {
                    var isExpanded by rememberSaveable { mutableStateOf(false) }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { isExpanded = !isExpanded }
                            .animateContentSize(), // Smooth animation for expansion
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) // Light primary color
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Header Row with Type Name and Expand/Collapse Icon
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = type,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Icon(
                                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }

                            // Expandable Meals List
                            AnimatedVisibility(visible = isExpanded) {
                                Column(modifier = Modifier.padding(top = 8.dp)) {
                                    mealsList.forEach { meal ->
                                        MealItem(meal = meal)
                                        Spacer(modifier = Modifier.height(8.dp)) // Space between meals
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
