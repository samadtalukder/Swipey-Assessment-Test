package com.samad_talukder.swipeyassessmenttest.data.repository


import android.content.Context
import com.samad_talukder.swipeyassessmenttest.data.api.ApiResult
import com.samad_talukder.swipeyassessmenttest.data.api.BaseApiResponse
import com.samad_talukder.swipeyassessmenttest.data.datasource.WeathersDataSource
import com.samad_talukder.swipeyassessmenttest.data.models.CurrentWeatherResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/


@ActivityRetainedScoped
class WeathersRepositoryImpl @Inject constructor(private val weathersDataSource: WeathersDataSource) :
    BaseApiResponse(), WeathersRepository {

    override suspend fun fetchWeatherData(
        context: Context,
        location: String
    ): Flow<ApiResult<CurrentWeatherResponse>> {
        return flow {
            emit(
                safeApiCall(
                    { weathersDataSource.getCurrentWeatherData(location) }, context
                )
            )
        }.flowOn(Dispatchers.IO)
    }

}