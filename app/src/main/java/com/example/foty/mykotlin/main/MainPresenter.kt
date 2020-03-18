package com.example.foty.mykotlin.main

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/9 11:57
 * Use by
 */
class MainPresenter(view: MainContract.View) : BasePresenter<MainContract.View>(view), MainContract.Presenter {

    override fun logout() {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).logout(),
                object : BaseObserver<String>() {
                    override fun onSuccess(data: String) {

                    }

                    override fun onError(e: ResponseException) {
                    }
                })
    }

}