package com.example.weatherclothes.presenter

import com.example.weatherclothes.util.PrefsUtil
import com.example.weatherclothes.model.Clothes
import com.example.weatherclothes.model.ConditionIcon
import com.example.weatherclothes.network.ApiServiceImp
import com.example.weatherclothes.response.BaseJson
import com.example.weatherclothes.response.WeatherResponse
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivityPresenter(private val view: IView) {
    private val apiService = ApiServiceImp()
    fun getCurrentWeatherCondition(city: String){
        apiService.getCurrentWeatherCondition(city).enqueue(
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    view.onDataGetFailed(e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.code == 200){
                        val responseBody = response.body?.string()
                        val result = Gson().fromJson(responseBody, BaseJson::class.java)
                        view.onDataGetSuccess(result.weatherResponse)
                    }else{
                        view.onDataGetFailed(response.body.toString())
                    }
                }

            }
        )
    }

    private fun checkSharedPreference(result: WeatherResponse) {
        val date = result.currentDay.split(" ")[0]
        val cloth = getAClothToWear(result.temp.toDouble().toInt())
        if (PrefsUtil.date != date){
            PrefsUtil.date = date
            PrefsUtil.cloth = cloth.toString()
        }
    }

    fun getWeatherIcon(condition: String): Int{
        val conditionIcon = ConditionIcon()
          return conditionIcon.getWeatherIcon(condition)
    }

    fun getAClothToWear(temp: Int): Int{
        val clothes = Clothes()
        return clothes.getCloth(temp)
    }
}
