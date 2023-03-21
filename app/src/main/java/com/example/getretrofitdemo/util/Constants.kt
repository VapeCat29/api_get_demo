package com.example.getretrofitdemo.util

import com.example.getretrofitdemo.api.SimpleApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig  {

    companion object{
        const val BASE_URL = "http://api.weatherapi.com/v1/"

        fun getApiService(): SimpleApi {

            // API response interceptor
            val loggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            // Client
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            // Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(SimpleApi::class.java)
        }

        var API_KEY = "ff9f895b2e884d6680530135202710"
    }
}