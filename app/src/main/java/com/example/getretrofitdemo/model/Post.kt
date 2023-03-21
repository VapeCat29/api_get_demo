package com.example.getretrofitdemo.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @field:SerializedName("current")
    val current: Current? = null,
)

data class Current (
    @SerializedName("temp_c")
    val celcius: Float,
    @SerializedName("temp_f")
    val fahrenheit: Float
    )