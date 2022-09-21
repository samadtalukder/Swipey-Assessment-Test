package com.samad_talukder.swipeyassessmenttest.data.datasource

import com.samad_talukder.swipeyassessmenttest.data.api.WeathersApi
import com.samad_talukder.swipeyassessmenttest.data.models.CurrentWeatherResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Samad Talukder on 21 September 2022
 * github.com/samadtalukder
 **/

class WeathersDataSourceImpl @Inject constructor(private var weathersApi: WeathersApi) :
    WeathersDataSource {

    override suspend fun getCurrentWeatherData(location: String): Response<CurrentWeatherResponse> {
        return weathersApi.getCurrentWeather(location)
    }

}