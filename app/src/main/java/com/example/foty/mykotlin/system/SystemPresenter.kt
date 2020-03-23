package com.example.foty.mykotlin.system

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.TreeBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/13 15:15
 * Use by
 */
class SystemPresenter(view: SystemConstract.View) : BasePresenter<SystemConstract.View>(view), SystemConstract.Presenter {
    override fun getDataList() {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).tree(),
                object : BaseObserver<List<TreeBean>>() {
                    override fun onSuccess(data: List<TreeBean>) {
                        view.loadDataSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                    }
                }
        )
    }
}