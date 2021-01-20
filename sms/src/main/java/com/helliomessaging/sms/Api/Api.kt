package com.helliomessaging.sms.Api

import com.helliomessaging.sms.SMS_URL
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST(SMS_URL)
    fun sendSMS(@FieldMap params : Map<String, String>) : Call<ResponseBody>

}