package com.example.foty.mykotlin.main

import com.example.foty.mykotlin.base.BasePresenter

/**
 * Create by lxx
 * Date : 2020/3/9 11:57
 * Use by
 */
class MainPresenter(view: MainContract.View) : BasePresenter<MainContract.View>(view), MainContract.Presenter {
    override fun logout() {
    }

}