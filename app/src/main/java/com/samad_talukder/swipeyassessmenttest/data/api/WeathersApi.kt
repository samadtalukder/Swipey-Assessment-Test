package com.samad_talukder.swipeyassessmenttest.data.api


import com.samad_talukder.swipeyassessmenttest.data.models.CurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Samad Talukder on 21 September 2022
 * github.com/samadtalukder
 **/

interface WeathersApi {

    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("q") location: String
    ): Response<CurrentWeatherResponse>
}