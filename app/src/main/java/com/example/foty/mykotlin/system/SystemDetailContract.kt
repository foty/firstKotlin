package com.example.foty.mykotlin.system

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.TreeDetailBean

/**
 * Create by lxx
 * Date : 2020/3/27 15:32
 * Use by
 */
interface SystemDetailContract {
    interface View : BaseView{
        fun loadDataSuccess(data: TreeDetailBean)
    }
    interface Presenter {
        fun getDatas(pageNum: Int, cid: Int)
    }
}