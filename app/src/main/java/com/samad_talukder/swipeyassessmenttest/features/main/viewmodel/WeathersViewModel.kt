package com.samad_talukder.swipeyassessmenttest.features.main.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.samad_talukder.swipeyassessmenttest.data.api.ApiResult
import com.samad_talukder.swipeyassessmenttest.data.models.CurrentWeatherResponse
import com.samad_talukder.swipeyassessmenttest.domain.usecase.WeathersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

@HiltViewModel
class WeathersViewModel @Inject constructor(
    application: Application,
    private val weathersUseCase: WeathersUseCase
) : AndroidViewModel(application) {


    private val mutableCurrentWeatherData: MutableLiveData<ApiResult<CurrentWeatherResponse>> =
        MutableLiveData()
    val liveDataCurrentWeather: LiveData<ApiResult<CurrentWeatherResponse>> =
        mutableCurrentWeatherData


    fun getCurrentWeather(context: Context, location: String) = viewModelScope.launch {
        mutableCurrentWeatherData.value = ApiResult.Loading()

        weathersUseCase.callCurrentWeatherApi(context, location).collect { values ->
            mutableCurrentWeatherData.value = values
        }
    }


}