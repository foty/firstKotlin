package com.example.foty.mykotlin.project

import android.util.Log
import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.ProjectBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/11 17:36
 * Use by
 */
class ProjectDetailPresenter(view: ProjectDetailConstract.View) : BasePresenter<ProjectDetailConstract.View>(view)
        , ProjectDetailConstract.Presenter {

    override fun getDetailArticle(pageNum: Int, cid: Int) {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).projectDetail(pageNum, cid)
                , object : BaseObserver<ProjectBean>() {
            override fun onSuccess(data: ProjectBean) {
                view.loadDetailSuccess(data)
            }

            override fun onError(e: ResponseException) {
            }
        })
    }
}