package com.example.weatherclothes.response

import com.google.gson.annotations.SerializedName

data class BaseJson (
    @SerializedName("current")
    val weatherResponse: WeatherResponse
)