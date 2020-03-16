package com.example.foty.mykotlin.navigation

import android.view.View
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseFragment
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.view.VerticalTabLayout
import kotlinx.android.synthetic.main.fragment_navigation.*

/**
 * Created by PlaceHolder on 2020/3/15.
 * use to :
 */
class NavigationFragment : BaseMvpFragment<NavigationPresenter>(), NavigationConstract.View {

    private val fragments: ArrayList<BaseFragment> = arrayListOf()


    companion object {
        fun newInstance(): NavigationFragment {
            return NavigationFragment()
        }
    }

    override fun initPresenter(): NavigationPresenter {
        return NavigationPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_navigation
    }

    override fun initData() {
    }

    override fun initView() {
        val tabList = arrayListOf<String>().apply {
            add("真丝毛毯1")
            add("真丝毛毯2")
            add("真丝毛毯3")
            add("真丝毛毯4")
        }

        fragments.add(NavFragmentDetail.newInstance())
        fragments.add(NavFragmentDetail.newInstance())
        fragments.add(NavFragmentDetail.newInstance())
        fragments.add(NavFragmentDetail.newInstance())
        naviTabLayout.addTabs(tabList)
        val transaction = fragmentManager!!.beginTransaction()
        for (item in fragments) {
            transaction.add(R.id.naviDetailContainer, item).hide(item)
        }
        transaction.show(fragments[0])
        transaction.commit()
//        transaction.commitAllowingStateLoss()
//        fragmentManager.executePendingTransactions()

        naviTabLayout.setOnTabClickListener(object : VerticalTabLayout.OnTabClickListener {
            override fun onTabClick(oldTabIndex: Int, newTabIndex: Int) {
                ToastUtil.show(mContext, "00000")
            }
        })

    }

    override fun initLoad() {
    }

}