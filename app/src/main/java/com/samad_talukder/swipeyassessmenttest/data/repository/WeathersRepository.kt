package com.samad_talukder.swipeyassessmenttest.data.repository

import android.content.Context
import com.samad_talukder.swipeyassessmenttest.data.api.ApiResult
import com.samad_talukder.swipeyassessmenttest.data.models.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

interface WeathersRepository {
    suspend fun fetchWeatherData(
        context: Context,
        location: String
    ): Flow<ApiResult<CurrentWeatherResponse>>
}