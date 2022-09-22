package com.samad_talukder.swipeyassessmenttest.utils

import java.text.SimpleDateFormat

object DateUtils {
    fun convertUpdatedDate(dateVal: String?): String? {
        val df = SimpleDateFormat("dd LLL yyyy hh:mm aa")
        val temp = SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateVal.toString())

        return df.format(temp?.time)
    }
}