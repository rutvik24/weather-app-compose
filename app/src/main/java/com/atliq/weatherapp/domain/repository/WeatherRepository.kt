package com.atliq.weatherapp.domain.repository

import com.atliq.weatherapp.domain.util.Resource
import com.atliq.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}