package com.example.foty.mykotlin.net.interceptor

import com.example.foty.mykotlin.utils.SpUtil
import okhttp3.Interceptor
import okhttp3.Response

class AddCookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = chain.request().newBuilder()
//        if (request.url().toString().contains("collect")) {
        val cookies = SpUtil.getCookies().split("#")
        for (cookie in cookies) {
            builder.addHeader("Cookie", cookie)
        }
//        }
        return chain.proceed(builder.build())
    }
}