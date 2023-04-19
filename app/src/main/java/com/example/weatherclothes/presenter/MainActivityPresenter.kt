package com.example.weatherclothes.presenter

import com.example.weatherclothes.R
import com.example.weatherclothes.util.PrefsUtil
import com.example.weatherclothes.model.Clothes
import com.example.weatherclothes.network.ApiServiceImp
import com.example.weatherclothes.response.BaseJson
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivityPresenter(private val view: IView) {
    private val apiService = ApiServiceImp()
    private var mDate = ""
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
                        mDate = result.weatherResponse.currentDay.split(" ")[0]
                        view.onDataGetSuccess(result.weatherResponse)
                    }else{
                        view.onDataGetFailed(response.body.toString())
                    }
                }

            }
        )
    }

    fun getWeatherIcon(condition: String): Int{
        return when (condition) {
            "Partly cloudy" -> R.drawable.partialy_cloudy
            "Cloudy" -> R.drawable.cloudy
            "Clear" ->  R.drawable.fine
            "Sunny" -> R.drawable.sunny
            "Overcast" -> R.drawable.cloudy
            else -> R.drawable.rainy
        }
    }

    fun getAClothToWear(temp: Int): Int{
        val clothes = Clothes()
        if (PrefsUtil.date != mDate || PrefsUtil.temp != temp.toString()){
            PrefsUtil.cloth = clothes.getCloth(temp).toString()
            PrefsUtil.temp = temp.toString()
            PrefsUtil.date = mDate
        }
        return PrefsUtil.cloth?.toInt()!!
    }
}
