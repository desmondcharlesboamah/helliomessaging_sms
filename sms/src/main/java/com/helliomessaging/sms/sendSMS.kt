package com.helliomessaging.sms

import android.app.Activity
import android.util.Log
import com.helliomessaging.sms.Api.RetrofitClient
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap



fun Activity.sendSMS(phone : String,clientID : String,
                     applicationSecret : String,
                     senderID : String,
                     message: String
    ,callback:(Boolean,message : String)->Unit){
    try {
        val hashedAuthKey = sha1("$clientID$applicationSecret$currentTimestamp")
        val param: MutableMap<String, String> = HashMap()
        param[AUTH_KEY] =hashedAuthKey
        param[CLIENT_ID] =clientID
        param[MSISDN] =phone
        param[SENDER_ID] =senderID
        param[MESSAGE] =message.trim()

        RetrofitClient.instance.sendSMS(param)
            .enqueue(object: Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    callback(false,getString(R.string.something_went_wrong))
                }
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    try {
                        response.body()?.apply {
                            val data =
                            callback(true,JSONObject(this.string()).toString())
                        }
                    }catch (e : Exception){
                        callback(false,getString(R.string.something_went_wrong))
                    }
                }
            })

    } catch (exc: Exception) {
        callback(false,getString(R.string.something_went_wrong))
    }
}