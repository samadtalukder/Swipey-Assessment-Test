package com.samad_talukder.swipeyassessmenttest.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

@HiltAndroidApp
class WeathersApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}