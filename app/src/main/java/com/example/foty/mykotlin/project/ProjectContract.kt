package com.example.foty.mykotlin.project

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.ProjectCategoryBean

/**
 * Create by lxx
 * Date : 2020/3/11 17:35
 * Use by
 */
interface ProjectContract {

    interface View : BaseView {
        fun loadProjectSuccess(data: List<ProjectCategoryBean>)
    }

    interface Presenter {
        fun getProjectList()
    }
}