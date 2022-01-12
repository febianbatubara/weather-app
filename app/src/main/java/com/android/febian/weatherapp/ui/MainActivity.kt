package com.android.febian.weatherapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.android.febian.weatherapp.R
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity
import com.android.febian.weatherapp.databinding.ActivityMainBinding
import com.android.febian.weatherapp.vo.Resource
import com.android.febian.weatherapp.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var loadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setupAlertDialog()

        viewModel.getWeather("Jakarta,ID").observe(this, weatherObserver)
    }

    private fun setupAlertDialog() {
        loadingDialog = AlertDialog.Builder(this)
            .setCancelable(false)
            .setView(R.layout.custom_progress_dialog)
            .create()
    }

    private val weatherObserver: Observer<Resource<WeatherItemEntity>> =
        Observer { weatherResource ->
            if (weatherResource != null) {
                when (weatherResource.status) {
                    Status.LOADING -> loadingDialog.show()
                    Status.SUCCESS -> {
                        loadingDialog.dismiss()
                        weatherResource.data?.let { weather ->
                            showWeatherData(weather)
                        }
                    }
                    Status.ERROR -> {
                        loadingDialog.dismiss()
                        Toast.makeText(
                            this,
                            "Error",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    private fun showWeatherData(weather: WeatherItemEntity) {
        with(binding) {
            tvTown.text = getString(R.string.city_and_country, weather.name, weather.sys?.country)
            tvUpdateTime.text = "Updated at: ---"
            tvWeatherType.text = weather.weather?.main ?: ""
            tvTemperature.text = getString(R.string.temp, weather.main?.temp.toString())
            tvMinTemperature.text = getString(R.string.min_temp, weather.main?.temp_min.toString())
            tvMaxTemperature.text = getString(R.string.max_temp, weather.main?.temp_max.toString())
            tvSunrise.text = weather.sys?.sunrise.toString()
            tvSunset.text = weather.sys?.sunset.toString()
            tvWind.text = weather.wind?.speed.toString()
            tvPressure.text = weather.main?.pressure.toString()
            tvHumidity.text = weather.main?.humidity.toString()
        }
    }
}