package com.example.getretrofitdemo.api

import com.example.getretrofitdemo.model.CurrentWeatherResponse
import com.example.getretrofitdemo.util.ApiConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    // Get current weather data
    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<CurrentWeatherResponse>
}