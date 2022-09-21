package com.samad_talukder.swipeyassessmenttest.data.interceptor

import com.samad_talukder.swipeyassessmenttest.data.provider.ApiKeyProvider
import com.samad_talukder.swipeyassessmenttest.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Samad Talukder on 22 September 2022.
 * github.com/samadtalukder
 **/

class QueryAddInterceptor @Inject constructor(private val apiKeyProvider: ApiKeyProvider) :
    Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val key = apiKeyProvider.apiKey
        val url = request.url.newBuilder().addQueryParameter(Constants.KEY_QUERY, key).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}