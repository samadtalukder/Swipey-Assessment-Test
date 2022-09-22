package com.samad_talukder.swipeyassessmenttest.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import com.samad_talukder.swipeyassessmenttest.data.api.ApiResult
import com.samad_talukder.swipeyassessmenttest.databinding.ActivityMainBinding
import com.samad_talukder.swipeyassessmenttest.features.main.viewmodel.WeathersViewModel
import com.samad_talukder.swipeyassessmenttest.utils.CustomProgressBar.hideProgressBar
import com.samad_talukder.swipeyassessmenttest.utils.CustomProgressBar.showProgressBar
import com.samad_talukder.swipeyassessmenttest.utils.hideKeyboard
import com.samad_talukder.swipeyassessmenttest.utils.loadWeatherIcon
import com.samad_talukder.swipeyassessmenttest.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import java.util.Objects.isNull

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val weathersViewModel by viewModels<WeathersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.edtSearchCity.setOnEditorActionListener { v, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {

                val searchCity = binding.edtSearchCity.text.toString()

                if (searchCity.isNotEmpty()) {
                    getCurrentWeather(searchCity)
                } else {
                    showToast("Please input a city name")
                }

                hideKeyboard(v)

                true
            }
            false
        }
        observeCurrentWeather()


    }


    private fun observeCurrentWeather() {

        weathersViewModel.liveDataCurrentWeather.observe(this) { response ->
            when (response) {

                is ApiResult.Loading -> {
                    showProgressBar(this)
                }

                is ApiResult.Success -> {
                    hideProgressBar()

                    if (!isNull(response.data)) {
                        response.data?.let {

                            binding.cvWeather.visibility = View.VISIBLE
                            binding.cvDetails.visibility = View.VISIBLE
                            binding.tvNoLocation.visibility = View.GONE

                            binding.tvLocation.text = "${it.location.name}, ${it.location.country}"
                            binding.tvTemperatureValue.text = "${it.current.temp_c}"
                            binding.tvCondition.text = it.current.condition.text
                            binding.ivWeatherIcon.loadWeatherIcon(it.current.condition.icon)

                            binding.tvHumidityValue.text = "${it.current.humidity} %"
                            binding.tvNwWindValue.text = "${it.current.wind_mph} mph"
                            binding.tvPressureValue.text = "${it.current.pressure_in} inHg"


                        }
                    }
                }

                is ApiResult.Error -> {
                    hideProgressBar()

                    binding.tvNoLocation.visibility = View.VISIBLE
                    binding.cvWeather.visibility = View.GONE
                    binding.cvDetails.visibility = View.GONE

                }

                is ApiResult.Nothing -> {
                    hideProgressBar()
                }
            }
        }

    }

    private fun getCurrentWeather(searchCity: String) {
        weathersViewModel.getCurrentWeather(this, searchCity)
    }
}