package weatherapp.ca.domain.repository

import weatherapp.ca.domain.util.Resource
import weatherapp.ca.domain.weather.WeatherInfo


interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}