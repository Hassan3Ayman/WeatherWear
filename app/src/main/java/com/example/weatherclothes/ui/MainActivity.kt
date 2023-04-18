package com.example.weatherclothes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weatherclothes.databinding.ActivityMainBinding
import com.example.weatherclothes.presenter.IView
import com.example.weatherclothes.presenter.MainActivityPresenter
import com.example.weatherclothes.response.WeatherResponse
import com.example.weatherclothes.util.PrefsUtil

class MainActivity : AppCompatActivity(), IView {
    lateinit var binding: ActivityMainBinding
    lateinit var presenter: MainActivityPresenter
    private val city = "cairo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        PrefsUtil.initPrefsUtil(this)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)
        presenter.getCurrentWeatherCondition(city)
    }


    private fun showWeatherDetails(result: WeatherResponse) {
        val condition = result.condition.condition
        runOnUiThread {
            binding.temperature.text = result.temp.toDouble().toInt().toString()
            binding.condition.text = condition
            binding.windSpeed.text = "${result.windSpeed.toDouble().toInt()}km/hr"
            binding.humidity.text = "${result.humidity.toDouble().toInt()}%"
            binding.temperatureSensible.text = "${result.tempFeeling.toDouble().toInt()}°C"
            binding.location.text = city
            binding.conditionImage.setImageResource(presenter.getWeatherIcon(condition))
            binding.imageCloth.setImageResource(presenter.getAClothToWear(result.temp.toDouble().toInt()))
        }
    }

    override fun onDataGetSuccess(result: WeatherResponse) {
        showWeatherDetails(result)
    }

    override fun onDataGetFailed(error: String) {
        runOnUiThread{
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}