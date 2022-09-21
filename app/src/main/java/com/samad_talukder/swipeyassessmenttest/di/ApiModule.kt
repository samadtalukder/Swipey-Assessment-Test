package com.samad_talukder.swipeyassessmenttest.di


import com.samad_talukder.swipeyassessmenttest.BuildConfig
import com.samad_talukder.swipeyassessmenttest.data.api.WeathersApi
import com.samad_talukder.swipeyassessmenttest.data.interceptor.QueryAddInterceptor
import com.samad_talukder.swipeyassessmenttest.data.provider.ApiKeyProvider
import com.samad_talukder.swipeyassessmenttest.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideKeyParameterInterceptor(apiKeyProvider: ApiKeyProvider): QueryAddInterceptor {
        return QueryAddInterceptor(apiKeyProvider)
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        queryAddInterceptor: QueryAddInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(queryAddInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(Constants.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(Constants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(Constants.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): WeathersApi =
        retrofit.create(WeathersApi::class.java)
}