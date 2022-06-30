package com.kotlinweather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.hgbrasil.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api : WeatherInterface = retrofit.create(WeatherInterface::class.java)
}