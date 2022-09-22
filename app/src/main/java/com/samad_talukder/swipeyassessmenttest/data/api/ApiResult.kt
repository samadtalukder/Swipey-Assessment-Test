package com.samad_talukder.swipeyassessmenttest.data.api

/**
 * Created by Samad Talukder on 21 September 2022.
 * github.com/samadtalukder
 **/

sealed class ApiResult<T>(
    val data: T? = null,
    val message: String? = null,
    val responseCode: String? = null
) {

    class Success<T>(data: T) : ApiResult<T>(data)

    class Error<T>(message: String, data: T? = null,responseCode:String) : ApiResult<T>(data, message,responseCode)

    class Loading<T> : ApiResult<T>()

    class Nothing<T> : ApiResult<T>()

}