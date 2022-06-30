package com.kotlinweather

import retrofit2.Call
import retrofit2.http.GET

interface WeatherInterface {
    @GET("weather?woeid=451782")
    fun getData() : Call<WeatherData>
}