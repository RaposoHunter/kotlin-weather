package com.kotlinweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    @GET("weather")
    fun getWeather(
        @Query("woeid") woeid : String
    ) : Call<WeatherData>
}