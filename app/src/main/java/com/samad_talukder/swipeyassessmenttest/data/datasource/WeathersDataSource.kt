package com.samad_talukder.swipeyassessmenttest.data.datasource

import com.samad_talukder.swipeyassessmenttest.data.models.CurrentWeatherResponse
import retrofit2.Response

/**
 * Created by Samad Talukder on 21 September 2022
 * github.com/samadtalukder
 **/

interface WeathersDataSource {
    suspend fun getCurrentWeatherData(location: String): Response<CurrentWeatherResponse>
}