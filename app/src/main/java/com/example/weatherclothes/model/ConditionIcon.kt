package com.example.weatherclothes.model

import com.example.weatherclothes.R

class ConditionIcon {
    private val icons = listOf<Int>(
        R.drawable.sunny,
        R.drawable.cloudy,
        R.drawable.fine,
        R.drawable.rainy,
        R.drawable.partialy_cloudy
    )

    fun getWeatherIcon(condition: String): Int {
        return when (condition) {
            "Partly cloudy" -> icons[4]
            "Cloudy" -> icons[1]
            "Clear" -> icons[2]
            "Sunny" -> icons[0]
            "Overcast" -> icons[1]
            else -> icons[3]
        }
    }
}