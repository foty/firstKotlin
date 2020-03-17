package com.example.foty.mykotlin.net

import com.example.foty.mykotlin.net.interceptor.AddCookiesInterceptor
import com.shehuan.wanandroid.base.net.interceptor.SaveCookiesInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Create by lxx
 * Date : 2020/3/17 15:28
 * Use by
 */
object RetrofitManager {

    private val okHttpClient: OkHttpClient by lazy {
        getOkClient()
    }

    /**
     * 获取请求服务实例
     */
    fun <T> create(clazz: Class<T>): T {
        return getRetrofit().create(clazz)
    }

    /**
     * 获取retrofit实例
     */
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.WAN_ANDROID_BASE_URL)
                .build()
    }

    /**
     * 创建Ok实例
     */
    private fun getOkClient(): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            connectTimeout(10000, TimeUnit.MILLISECONDS)
            readTimeout(10000, TimeUnit.MILLISECONDS)
            writeTimeout(10000, TimeUnit.MILLISECONDS)
            //日志拦截器
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
            //cookie相关拦截器
            addInterceptor(SaveCookiesInterceptor())
            addInterceptor(AddCookiesInterceptor())
        }.build()
    }
}