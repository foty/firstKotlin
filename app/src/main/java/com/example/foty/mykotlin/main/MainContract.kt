package com.example.foty.mykotlin.main

import com.example.foty.mykotlin.base.BaseView

/**
 * Create by lxx
 * Date : 2020/3/9 15:57
 * Use by
 */
interface MainContract {
    interface View : BaseView {
        fun onLogoutSuccess(data: String)
    }

    interface Presenter {
        fun logout()
    }
}