package com.samad_talukder.swipeyassessmenttest.di

import com.samad_talukder.swipeyassessmenttest.data.api.WeathersApi
import com.samad_talukder.swipeyassessmenttest.data.datasource.WeathersDataSource
import com.samad_talukder.swipeyassessmenttest.data.datasource.WeathersDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Samad Talukder on 22 September 2022.
 * github.com/samadtalukder
 **/

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideWeathersDataSource(weathersApi: WeathersApi): WeathersDataSource {
        return WeathersDataSourceImpl(weathersApi)
    }
}