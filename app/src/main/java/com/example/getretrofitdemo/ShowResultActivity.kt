package com.example.getretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.getretrofitdemo.databinding.ActivityMainBinding
import com.example.getretrofitdemo.databinding.ActivityShowResultBinding

class ShowResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShowResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val response = intent.extras
        if (response != null){
            binding.celciusEditText.setText(response.getString("celcius"))
            binding.fahrenheitEditText.setText(response.getString("fahrenheit"))
        }
    }
}