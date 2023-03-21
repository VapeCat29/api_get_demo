package com.example.getretrofitdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.getretrofitdemo.databinding.ActivityMainBinding
import com.example.getretrofitdemo.model.CurrentWeatherResponse
import com.example.getretrofitdemo.util.ApiConfig

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel :MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onResume() {
        super.onResume()
        val items = listOf("Kuala Lumpur", "Singapore")
        val adapter = ArrayAdapter( baseContext, R.layout.list_item, items)
        binding.cityDropdownedittext.setAdapter(adapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel = MainViewModel()

        binding.apikeyEditText.setText("ff9f895b2e884d6680530135202710")

        binding.submitButton.setOnClickListener {
            val apiKey:String = binding.apikeyEditText.text.toString()
            val city:String = binding.cityDropdownedittext.text.toString()

            ApiConfig.API_KEY = apiKey

            mainViewModel.getWeatherData(city)
            mainViewModel.weatherData.observe(this) { weatherData ->
                // Display weather data to the UI
                setResultText(weatherData)
            }
        }

    }

    private fun setResultText(weatherData: CurrentWeatherResponse) {
        var celcius: String
        var fahrenheit: String

        weatherData.current.let { current ->
            celcius = ("${current?.celcius}")
            fahrenheit = ("${current?.fahrenheit}")
        }

        val APIResponse = Bundle()
        APIResponse.putString("celcius",celcius)
        APIResponse.putString("fahrenheit",fahrenheit)

        val intent = Intent(this, ShowResultActivity::class.java)
        intent.putExtras(APIResponse)
        startActivity(intent)

    }

}