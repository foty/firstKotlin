package com.example.foty.mykotlin.base

import android.content.Context

/**
 * Create by lxx
 * Date : 2020/3/9 11:47
 * Use by
 */
abstract class BasePresenter<V : BaseView>(val view: V) {

    protected val context: Context = if (view is BaseFragment) {
        view.mContext
    } else {
        view as Context
    }

}