package com.helliomessaging.sms

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * Returns the current timestamp
 *
 * @return current timestamp
 */
val currentTimestamp: String
    @SuppressLint("SimpleDateFormat")
    get() {
        val sdf = SimpleDateFormat("yMMddHH")
        val currentDateandTime = sdf.format(Date())
        return currentDateandTime
    }
