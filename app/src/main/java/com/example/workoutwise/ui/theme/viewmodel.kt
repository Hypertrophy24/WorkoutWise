// MainViewModel.kt
package com.example.workoutwise.ui.theme

import androidx.lifecycle.ViewModel
import com.example.workoutwise.data.DataProvider
import com.example.workoutwise.model.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for the WorkoutWise app.
 * Manages workouts, weather data, and suggests workouts based on weather conditions.
 */
class MainViewModel : ViewModel() {

    // ---------------------------
    // Weather-Related State Flows
    // ---------------------------

    // Holds the current weather description (e.g., "Sunny", "Rainy")
    private val _weatherDescription = MutableStateFlow<String?>(null)
    val weatherDescription: StateFlow<String?> = _weatherDescription.asStateFlow()

    // Holds the current temperature
    private val _temperature = MutableStateFlow<Int?>(null)
    val temperature: StateFlow<Int?> = _temperature.asStateFlow()

    // Holds the suggested workout based on the weather
    private val _suggestedWorkout = MutableStateFlow<Workout?>(null)
    val suggestedWorkout: StateFlow<Workout?> = _suggestedWorkout.asStateFlow()

    // ---------------------------
    // Workouts Management
    // ---------------------------

    // Private mutable StateFlow holding the list of workouts
    private val _workouts = MutableStateFlow<List<Workout>>(DataProvider.workouts)
    val workouts: StateFlow<List<Workout>> = _workouts.asStateFlow()

    /**
     * Updates the weather data and computes the suggested workout based on new conditions.
     *
     * @param description The current weather description (e.g., "Sunny", "Rainy").
     * @param temp The current temperature.
     */
    fun updateWeather(description: String?, temp: Int?) {
        _weatherDescription.value = description
        _temperature.value = temp
        _suggestedWorkout.value = computeSuggestedWorkout(description, temp)
    }

    /**
     * Computes the suggested workout based on the provided weather conditions.
     *
     * @param description The current weather description.
     * @param temp The current temperature.
     * @return A Workout object that best fits the current weather conditions.
     */
    private fun computeSuggestedWorkout(description: String?, temp: Int?): Workout? {
        return when {
            description?.contains("Rain", ignoreCase = true) == true -> {
                // Suggest Strength workouts during Rainy weather
                workouts.value.find { it.type.equals("Strength", ignoreCase = true) }
            }
            description?.contains("Snow", ignoreCase = true) == true -> {
                // Suggest Flexibility workouts during Snowy weather
                workouts.value.find { it.type.equals("Flexibility", ignoreCase = true) }
            }
            description?.contains("Sunny", ignoreCase = true) == true -> {
                // Suggest Cardio workouts during Sunny weather
                workouts.value.find { it.type.equals("Cardio", ignoreCase = true) }
            }
            temp != null && temp < 10 -> {
                // Suggest Flexibility workouts when temperature is below 10°C
                workouts.value.find { it.type.equals("Flexibility", ignoreCase = true) }
            }
            temp != null && temp > 30 -> {
                // Suggest Cardio workouts when temperature is above 30°C
                workouts.value.find { it.type.equals("Cardio", ignoreCase = true) }
            }
            else -> {
                // Default to Strength workouts if no specific conditions are met
                workouts.value.find { it.type.equals("Strength", ignoreCase = true) }
            }
        }
    }

    // ---------------------------
    // Workouts Modification Functions
    // ---------------------------

    /**
     * Adds a new workout to the list.
     *
     * @param workout The Workout object to be added.
     */
    fun addWorkout(workout: Workout) {
        _workouts.value = _workouts.value + workout
    }

    /**
     * Removes an existing workout from the list.
     *
     * @param workout The Workout object to be removed.
     */
    fun removeWorkout(workout: Workout) {
        _workouts.value = _workouts.value - workout
    }

    /**
     * Updates an existing workout in the list.
     *
     * @param updatedWorkout The Workout object with updated details.
     */
    fun updateWorkout(updatedWorkout: Workout) {
        _workouts.value = _workouts.value.map { workout ->
            if (workout.name == updatedWorkout.name) updatedWorkout else workout
        }
    }

    /**
     * Retrieves workouts filtered by a specific type.
     *
     * @param type The type of workouts to filter (e.g., "Cardio", "Strength").
     * @return A list of workouts matching the specified type.
     */
    fun getWorkoutsByType(type: String): List<Workout> {
        return _workouts.value.filter { it.type.equals(type, ignoreCase = true) }
    }

    /**
     * Refreshes the workouts list, useful if workouts are fetched from a remote source.
     *
     * @param newWorkouts The new list of workouts to replace the existing list.
     */
    fun refreshWorkouts(newWorkouts: List<Workout>) {
        _workouts.value = newWorkouts
    }

    // Add more functions as needed to handle dynamic data operations.
}
