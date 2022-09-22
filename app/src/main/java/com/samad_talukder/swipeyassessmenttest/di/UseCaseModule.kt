package com.samad_talukder.swipeyassessmenttest.di

import com.samad_talukder.swipeyassessmenttest.data.repository.WeathersRepository
import com.samad_talukder.swipeyassessmenttest.domain.usecase.WeathersUseCase
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
class UseCaseModule {

    @Singleton
    @Provides
    fun provideWeathersUseCase(weathersRepository: WeathersRepository): WeathersUseCase {
        return WeathersUseCase(weathersRepository)
    }
}