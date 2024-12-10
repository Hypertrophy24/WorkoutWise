// WeatherScreen.kt
package com.example.workoutwise.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutwise.network.RetrofitClient
import kotlinx.coroutines.launch

@Composable
fun WeatherScreen(mainViewModel: MainViewModel) {
    var locationQuery by rememberSaveable { mutableStateOf("") }
    var weatherInfo by rememberSaveable { mutableStateOf("Enter a location and press Fetch") }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Weather",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = locationQuery,
            onValueChange = { locationQuery = it },
            label = { Text("Enter Location") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (locationQuery.isNotBlank()) {
                    coroutineScope.launch {
                        try {
                            val response = RetrofitClient.apiService.getCurrentWeather(
                                accessKey = "YourWEATHERAPI", // Replace with your actual API key
                                query = locationQuery
                            )

                            if (response.isSuccessful) {
                                val weatherResponse = response.body()
                                if (weatherResponse?.success != false) {
                                    val description = weatherResponse?.current?.weather_descriptions?.firstOrNull()
                                    val temp = weatherResponse?.current?.temperature

                                    weatherInfo = "Location: ${weatherResponse?.location?.name}, ${weatherResponse?.location?.country}\n" +
                                            "Temperature: ${temp}°C\n" +
                                            "Description: $description"

                                    // Update the ViewModel with the fetched weather data
                                    mainViewModel.updateWeather(description, temp)
                                } else {
                                    val errorMsg = "Error: ${weatherResponse?.error?.info}"
                                    weatherInfo = errorMsg
                                    Log.e("WeatherScreen", "API Error: ${weatherResponse?.error}")
                                }
                            } else {
                                val errorBody = response.errorBody()?.string()
                                weatherInfo = "Failed to load weather data."
                                Log.e("WeatherScreen", "Response Error: $errorBody")
                            }
                        } catch (e: Exception) {
                            weatherInfo = "Failed to load weather data."
                            Log.e("WeatherScreen", "Exception: ${e.message}")
                        }
                    }
                } else {
                    weatherInfo = "Please enter a valid location."
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Fetch")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = weatherInfo,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
