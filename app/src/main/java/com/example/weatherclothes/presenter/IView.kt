package com.example.weatherclothes.presenter

import com.example.weatherclothes.response.WeatherResponse

interface IView {
    fun onDataGetSuccess(result: WeatherResponse)
    fun onDataGetFailed(error: String)
}