package com.example.foty.mykotlin.navigation

import android.os.Bundle
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseFragment
import com.example.foty.mykotlin.beans.ArticlesItem
import com.example.foty.mykotlin.beans.NaviBean
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.utils.addCommonView
import kotlinx.android.synthetic.main.fragment_nav_detail.*

/**
 * Created by PlaceHolder on 2020/3/15.
 * use to :
 */
class NavFragmentDetail : BaseFragment() {

    companion object {
        fun newInstance(list: ArrayList<ArticlesItem>): NavFragmentDetail {
            val f = NavFragmentDetail()
            f.arguments = Bundle().apply {
                putParcelableArrayList("list", list)
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
        val list = arguments?.getParcelableArrayList<ArticlesItem>("list") ?: ArrayList()

        for (item in list) {
            navDetailFL.addCommonView(mContext, item.title, R.color.c2C2C2C, R.drawable.website_selecter) {
                ToastUtil.show(mContext, "666")
            }
        }
    }

    override fun initLoad() {
    }
}