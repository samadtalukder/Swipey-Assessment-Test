package com.samad_talukder.swipeyassessmenttest.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.samad_talukder.swipeyassessmenttest.R

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadWeatherIcon(
    imgUrl: String,
    @DrawableRes placeholder: Int = R.drawable.ic_weather
) {
    Glide
        .with(this)
        .load("http:$imgUrl")
        .placeholder(placeholder)
        .into(this)

}