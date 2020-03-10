package com.example.foty.mykotlin.fragment

import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseFragment

/**
 * Create by lxx
 * Date : 2020/3/10 16:36
 * Use by
 */
class HomeFragment : BaseFragment() {

    /**
     * 静态方法
     */
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun initLoad() {
    }
}