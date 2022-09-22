package com.samad_talukder.swipeyassessmenttest.data.models

/**
 * Created by Samad Talukder on 21 September 2022
 * github.com/samadtalukder
 **/

data class CurrentWeatherResponse(
    val location: LocationData,
    val current: CurrentWeatherData
)
