package com.example.foty.mykotlin.system

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.TreeDetailBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/27 15:34
 * Use by
 */
class SystemDetailPresenter(view: SystemDetailContract.View) : BasePresenter<SystemDetailContract.View>(view)
        , SystemDetailContract.Presenter {
    override fun getDatas(pageNum: Int, cid: Int) {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).treeDetail(pageNum, cid),
                object : BaseObserver<TreeDetailBean>() {
                    override fun onSuccess(data: TreeDetailBean) {
                        view.loadDataSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                    }
                })
    }
}