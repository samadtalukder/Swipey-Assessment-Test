package com.samad_talukder.swipeyassessmenttest.di

import android.app.Application
import android.content.Context
import com.samad_talukder.swipeyassessmenttest.data.provider.ApiKeyProvider
import com.samad_talukder.swipeyassessmenttest.data.provider.ApiKeyProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Samad Talukder on 22 September 2022.
 * github.com/samadtalukder
 **/

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideApiKeyProvider(): ApiKeyProvider {
        return ApiKeyProviderImpl()
    }
}