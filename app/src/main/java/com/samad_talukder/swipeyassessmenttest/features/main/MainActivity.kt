package com.samad_talukder.swipeyassessmenttest.features.main

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.samad_talukder.swipeyassessmenttest.data.api.ApiResult
import com.samad_talukder.swipeyassessmenttest.databinding.ActivityMainBinding
import com.samad_talukder.swipeyassessmenttest.features.main.viewmodel.WeathersViewModel
import com.samad_talukder.swipeyassessmenttest.utils.CustomProgressBar.hideProgressBar
import com.samad_talukder.swipeyassessmenttest.utils.CustomProgressBar.showProgressBar
import com.samad_talukder.swipeyassessmenttest.utils.DateUtils
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

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

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
                            val lastUpdatedTime = DateUtils.convertUpdatedDate(it.current.last_updated)

                            binding.cvWeather.visibility = View.VISIBLE
                            binding.cvDetails.visibility = View.VISIBLE
                            binding.tvNoLocation.visibility = View.GONE

                            binding.tvLocation.text = "${it.location.name}, ${it.location.country}"
                            binding.tvTemperatureValue.text = "${it.current.temp_c}"
                            binding.tvLastUpdated.text = "Last Updated: $lastUpdatedTime"
                            binding.tvCondition.text = it.current.condition.text
                            binding.tvFeelsLike.text = "Real Feel ${it.current.feelslike_c}"

                            binding.ivWeatherIcon.loadWeatherIcon(it.current.condition.icon)

                            binding.tvHumidityValue.text = "${it.current.humidity} %"
                            binding.tvNwWindValue.text = "${it.current.wind_kph} km/h"
                            binding.tvPressureValue.text = "${it.current.pressure_in} inHg"
                            binding.tvUvIndexValue.text = "${it.current.uv} of 10"


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