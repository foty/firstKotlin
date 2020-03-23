package com.example.foty.mykotlin.accounts

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.ChapterBean

/**
 * Create by lxx
 * Date : 2020/3/17 14:34
 * Use by
 */
interface AccountsContract {
    interface View : BaseView {
        fun loadDataSuccess(data: List<ChapterBean>)
    }

    interface Presenter {
        fun getData()
    }
}