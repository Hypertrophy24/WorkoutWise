package com.example.workoutwise.network

data class WeatherResponse(
    val request: Request?,
    val location: Location?,
    val current: Current?,
    val success: Boolean? = true,
    val error: ApiError? = null
)

data class Request(
    val type: String?,
    val query: String?,
    val language: String?,
    val unit: String?
)

data class Location(
    val name: String?,
    val country: String?,
    val region: String?,
    val lat: String?,
    val lon: String?,
    val timezone_id: String?,
    val localtime: String?,
    val localtime_epoch: Long?,
    val utc_offset: String?
)

data class Current(
    val observation_time: String?,
    val temperature: Int?,
    val weather_code: Int?,
    val weather_icons: List<String>?,
    val weather_descriptions: List<String>?,
    val wind_speed: Int?,
    val wind_degree: Int?,
    val wind_dir: String?,
    val pressure: Int?,
    val precip: Double?,
    val humidity: Int?,
    val cloudcover: Int?,
    val feelslike: Int?,
    val uv_index: Int?,
    val visibility: Int?,
    val is_day: String?
)

data class ApiError(
    val code: Int?,
    val type: String?,
    val info: String?
)
