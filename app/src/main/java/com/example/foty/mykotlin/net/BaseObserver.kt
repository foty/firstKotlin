package com.example.foty.mykotlin.net

import android.text.TextUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Create by lxx
 * Date : 2020/3/18 17:23
 * Use by
 */
abstract class BaseObserver<T> : Observer<T> {

    private lateinit var disposable: Disposable


    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
//        val responseException: ResponseException = e as ResponseException
//        val errorMessage = responseException.getErrorMessage()
        e.printStackTrace()
        onError(e)
    }

    fun getDisposable() = disposable

    abstract fun onSuccess(data: T)

    abstract fun onError(e: ResponseException)
}