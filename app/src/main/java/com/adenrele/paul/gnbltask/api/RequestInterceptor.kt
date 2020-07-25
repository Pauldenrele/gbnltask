package com.adenrele.paul.gnbltask.api

import com.adenrele.paul.gnbltask.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("X-Auth-Token", BuildConfig.API_KEY)
            .build()
        return chain.proceed(request)
    }
}