package com.samad_talukder.swipeyassessmenttest.data.api


import android.content.Context
import com.samad_talukder.swipeyassessmenttest.utils.ConnectivityUtils
import retrofit2.Response

/**
 * Created by Samad Talukder on 22 September 2022.
 * github.com/samadtalukder
 **/

abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> Response<T>,
        context: Context
    ): ApiResult<T> {
        try {
            if (ConnectivityUtils.hasInternetConnection(context)) {

                val response = apiCall()

                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        return ApiResult.Success(it)
                    }
                }

                return error(response.errorBody().toString(), response.code().toString())
            }
            return error("No Internet Connection", "")

        } catch (ex: Exception) {
            return error(ex.message ?: ex.toString(), "")
        }
    }

    private fun <T> error(errorMessage: String = "", responseCode: String = ""): ApiResult<T> =
        ApiResult.Error(errorMessage, responseCode = responseCode)
}