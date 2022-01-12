package com.android.febian.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.febian.weatherapp.data.InteractorImpl
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity
import com.android.febian.weatherapp.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val interactorImpl: InteractorImpl) : ViewModel() {

    fun getWeather(city: String): LiveData<Resource<WeatherItemEntity>> =
        interactorImpl.getWeather(city)
}