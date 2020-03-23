package com.example.foty.mykotlin.system

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.TreeBean

/**
 * Create by lxx
 * Date : 2020/3/13 15:14
 * Use by
 */
interface SystemConstract {
    interface View : BaseView {
        fun loadDataSuccess(data: List<TreeBean>)
    }

    interface Presenter {
        fun getDataList()
    }
}