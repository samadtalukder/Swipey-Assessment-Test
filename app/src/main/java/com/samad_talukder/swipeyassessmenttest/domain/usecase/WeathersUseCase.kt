package com.samad_talukder.swipeyassessmenttest.domain.usecase

import android.content.Context
import com.samad_talukder.swipeyassessmenttest.data.repository.WeathersRepository

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

class WeathersUseCase(private val weathersRepository: WeathersRepository) {

    suspend fun callCurrentWeatherApi(context: Context, location: String) =
        weathersRepository.fetchWeatherData(context, location)
}