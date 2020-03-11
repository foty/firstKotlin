package com.example.foty.mykotlin.fragment

import com.example.foty.mykotlin.base.BaseView

/**
 * Create by lxx
 * Date : 2020/3/11 10:29
 * Use by
 */
interface HomeContract {

    interface View : BaseView {

    }

    interface Presenter {

        fun getBannerData()

    }
}