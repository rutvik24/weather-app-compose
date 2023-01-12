package com.atliq.weatherapp.data.repository

import com.atliq.weatherapp.data.mappers.toWeatherInfo
import com.atliq.weatherapp.data.remote.WeatherApi
import com.atliq.weatherapp.domain.repository.WeatherRepository
import com.atliq.weatherapp.domain.util.Resource
import com.atliq.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data =  api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
