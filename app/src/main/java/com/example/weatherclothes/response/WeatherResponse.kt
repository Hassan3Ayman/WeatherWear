package com.example.weatherclothes.response

import com.example.weatherclothes.response.Condition
import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("temp_c")
    val temp : String,
    @SerializedName("wind_kph")
    val windSpeed: String,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("feelslike_c")
    val tempFeeling: String,
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("last_updated")
    val currentDay: String
    )