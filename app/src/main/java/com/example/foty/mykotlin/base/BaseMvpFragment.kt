package com.example.foty.mykotlin.base

import android.os.Bundle

/**
 * Create by lxx
 * Date : 2020/3/11 10:20
 * Use by
 */
abstract class BaseMvpFragment<P : BasePresenter<*>> :BaseFragment() {
    lateinit var presenter: P

    abstract fun initPresenter() : P

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        presenter = initPresenter()
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}