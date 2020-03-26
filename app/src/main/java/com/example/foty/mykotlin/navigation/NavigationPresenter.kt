package com.example.foty.mykotlin.navigation

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.NaviBean
import com.example.foty.mykotlin.net.*

/**
 * Created by PlaceHolder on 2020/3/15.
 * use to :
 */
class NavigationPresenter(view: NavigationContract.View) : BasePresenter<NavigationContract.View>(view), NavigationContract.Presenter {
    override fun getNavData() {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).nav()
                , object : BaseObserver<List<NaviBean>>() {
            override fun onSuccess(data: List<NaviBean>) {
                view.lodaDataSuccess(data)
            }

            override fun onError(e: ResponseException) {
            }
        })
    }
}