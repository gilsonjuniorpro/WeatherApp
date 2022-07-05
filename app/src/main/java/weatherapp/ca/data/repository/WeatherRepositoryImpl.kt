package weatherapp.ca.data.repository

import weatherapp.ca.data.mappers.toWeatherInfo
import weatherapp.ca.data.remote.WeatherApi
import weatherapp.ca.domain.repository.WeatherRepository
import weatherapp.ca.domain.util.Resource
import weatherapp.ca.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
