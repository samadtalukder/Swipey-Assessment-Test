package com.samad_talukder.swipeyassessmenttest.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.samad_talukder.swipeyassessmenttest.R
import com.samad_talukder.swipeyassessmenttest.features.main.viewmodel.WeathersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val weathersViewModel by viewModels<WeathersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeCurrentWeather()
        getCurrentWeather()

    }

    private fun observeCurrentWeather() {

    }

    private fun getCurrentWeather() {
        weathersViewModel.getCurrentWeather(this,"Petaling Jaya")
    }
}