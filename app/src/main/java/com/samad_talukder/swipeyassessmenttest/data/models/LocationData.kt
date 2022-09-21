package com.samad_talukder.swipeyassessmenttest.data.models

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

data class LocationData(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime_epoch: Int,
    val localtime: String
)
