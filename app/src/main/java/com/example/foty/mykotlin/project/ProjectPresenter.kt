package com.example.foty.mykotlin.project

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.ProjectCategoryBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/11 17:36
 * Use by
 */
class ProjectPresenter(view: ProjectContract.View) : BasePresenter<ProjectContract.View>(view), ProjectContract.Presenter {
    override fun getProjectList() {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).projectCategory(),
                object : BaseObserver<List<ProjectCategoryBean>>() {
                    override fun onSuccess(data: List<ProjectCategoryBean>) {
                        view.loadProjectSuccess(data)
                    }

                    override fun onError(e: ResponseException) {

                    }
                })
    }

}