package com.example.foty.mykotlin.accounts

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.ChapterBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/17 14:34
 * Use by
 */
class AccountsPresenter(view: AccountsContract.View) : BasePresenter<AccountsContract.View>(view), AccountsContract.Presenter {
    override fun getData() {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).chapter()
                , object : BaseObserver<List<ChapterBean>>() {
            override fun onError(e: ResponseException) {

            }

            override fun onSuccess(data: List<ChapterBean>) {
                view.loadDataSuccess(data)
            }
        })
    }
}