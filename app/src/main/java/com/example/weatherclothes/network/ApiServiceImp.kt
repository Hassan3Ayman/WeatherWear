package com.example.weatherclothes.network

import com.example.weatherclothes.network.ApiClient
import okhttp3.Call

class ApiServiceImp {
    private val client = ApiClient()

    fun getCurrentWeatherCondition(city: String): Call {
        val endPoint = "current.json"
        return client.getRequest(endPoint, city)
    }
}