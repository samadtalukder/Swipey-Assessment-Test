package com.samad_talukder.swipeyassessmenttest.data.provider

import com.samad_talukder.swipeyassessmenttest.BuildConfig

/**
 * Created by Samad Talukder on 22 September 2022.
 * github.com/samadtalukder
 **/

class ApiKeyProviderImpl : ApiKeyProvider {
    override val apiKey: String = BuildConfig.API_KEY
}