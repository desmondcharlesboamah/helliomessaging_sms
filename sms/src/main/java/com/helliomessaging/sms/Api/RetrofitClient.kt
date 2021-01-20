package com.helliomessaging.sms.Api

import android.util.Base64
import com.helliomessaging.sms.PARENT_URL
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val AUTH = "Basic " + Base64.encodeToString("helliomessaging".toByteArray(), Base64.NO_WRAP)


    private val okHttpClient = OkHttpClient.Builder()

        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Authorization", AUTH)
                .method(original.method, original.body)

            val request = requestBuilder.build()
            chain.proceed(request)

        }
        .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS))

        .build()

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(PARENT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }
}
