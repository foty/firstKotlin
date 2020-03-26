package com.example.foty.mykotlin.navigation

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.NaviBean

/**
 * Created by PlaceHolder on 2020/3/15.
 * use to :
 */
interface NavigationContract {
    interface View : BaseView {
        fun lodaDataSuccess(data: List<NaviBean>)
    }

    interface Presenter {
        fun getNavData()
    }
}