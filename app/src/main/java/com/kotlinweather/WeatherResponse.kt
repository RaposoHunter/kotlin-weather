package com.kotlinweather

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("date")
    val date : String,

    @SerializedName("weekday")
    val weekday : String,

    @SerializedName("max")
    val max : Int,

    @SerializedName("min")
    val min : Int,

    @SerializedName("description")
    val description : String,

    @SerializedName("condition")
    val condition : String
)

data class Results(
    @SerializedName("temp")
    val temp : Int,

    @SerializedName("date")
    val date : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("city")
    val city : String,

    @SerializedName("wind_speedy")
    val wind_speedy : String,

    @SerializedName("humidity")
    val humidity : String,

    @SerializedName("img_id")
    val img_id : String,

    @SerializedName("forecast")
    val forecast : List<Forecast>
)

data class WeatherData(
    @SerializedName("by")
    val by : String,

    @SerializedName("results")
    val results : Results,

    @SerializedName("from_cache")
    val from_cache : String,
)