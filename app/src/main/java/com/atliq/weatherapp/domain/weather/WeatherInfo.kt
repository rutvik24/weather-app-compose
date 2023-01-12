package com.atliq.weatherapp.domain.weather


data class WeatherInfo(
    val weatherDataPerDay: Map<Int,List<WeatherData>>,
    val currentWeatherData: WeatherData?
)

