package com.example.foty.mykotlin.navigation

import android.os.Bundle
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseFragment
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.utils.addCommonView
import kotlinx.android.synthetic.main.fragment_nav_detail.*

/**
 * Created by PlaceHolder on 2020/3/15.
 * use to :
 */
class NavFragmentDetail : BaseFragment() {

    companion object {
        fun newInstance(str: String): NavFragmentDetail {
            val f = NavFragmentDetail()
            f.arguments = Bundle().apply {
                putString("str", str)
            }
            return f
        }
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_nav_detail
    }

    override fun initData() {
    }

    override fun initView() {
        val str = arguments.getString("str")

        navDetailFL.addCommonView(mContext, "哈哈哈$str", R.color.c2C2C2C, R.drawable.website_selecter) {
            ToastUtil.show(mContext, "666")
        }
    }

    override fun initLoad() {
    }
}