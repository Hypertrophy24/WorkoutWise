// MainViewModel.kt
package com.example.workoutwise.ui.theme

import androidx.lifecycle.ViewModel
import com.example.workoutwise.data.DataProvider.workouts
import com.example.workoutwise.model.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow



class MainViewModel : ViewModel() {
    // Holds the current weather description (e.g., "Sunny", "Rainy")
    private val _weatherDescription = MutableStateFlow<String?>(null)
    val weatherDescription = _weatherDescription.asStateFlow()

    // Holds the current temperature
    private val _temperature = MutableStateFlow<Int?>(null)
    val temperature = _temperature.asStateFlow()

    // Holds the suggested workout based on the weather
    private val _suggestedWorkout = MutableStateFlow<Workout?>(null)
    val suggestedWorkout = _suggestedWorkout.asStateFlow()

    // Define your workouts list


    // Function to update weather data and compute suggested workout
    fun updateWeather(description: String?, temp: Int?) {
        _weatherDescription.value = description
        _temperature.value = temp
        _suggestedWorkout.value = computeSuggestedWorkout(description, temp)
    }

    // Function to compute the suggested workout based on weather conditions
    private fun computeSuggestedWorkout(description: String?, temp: Int?): Workout? {
        return when {
            description?.contains("Rain", ignoreCase = true) == true -> {
                workouts.find { it.type == "Strength" } // Example: Suggest Strength training on rainy days
            }
            description?.contains("Snow", ignoreCase = true) == true -> {
                workouts.find { it.type == "Flexibility" } // Example: Suggest Yoga or Pilates on snowy days
            }
            description?.contains("Sunny", ignoreCase = true) == true -> {
                workouts.find { it.type == "Cardio" } // Example: Suggest Outdoor Run or HIIT Cardio on sunny days
            }
            temp != null && temp < 10 -> {
                workouts.find { it.type == "Flexibility" } // Suggest Flexibility workouts in cold temperatures
            }
            temp != null && temp > 30 -> {
                workouts.find { it.type == "Cardio" } // Suggest Cardio workouts in hot temperatures
            }
            else -> {
                workouts.find { it.type == "Strength" } // Default suggestion
            }
        }
    }
}
