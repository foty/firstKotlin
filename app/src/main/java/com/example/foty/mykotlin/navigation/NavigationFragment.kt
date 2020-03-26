package com.example.foty.mykotlin.navigation

import android.util.Log
import android.view.View
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseFragment
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.view.VerticalTabLayout
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlin.math.log

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
        Log.d("lxx", "NavigationFragment()")
        val tabList = arrayListOf<String>().apply {
            add("真丝毛毯1")
            add("真丝毛毯2")
            add("真丝毛毯3")
            add("真丝毛毯4")
        }

        fragments.add(NavFragmentDetail.newInstance("11111"))
        fragments.add(NavFragmentDetail.newInstance("22222"))
        fragments.add(NavFragmentDetail.newInstance("33333"))
        fragments.add(NavFragmentDetail.newInstance("44444"))
        naviTabLayout.addTabs(tabList)
        val transaction = childFragmentManager!!.beginTransaction()

        for (item in fragments) {
            transaction.add(R.id.naviDetailContainer, item).hide(item)
        }
        transaction.show(fragments[0])
        transaction.commit()

        naviTabLayout.setOnTabClickListener(object : VerticalTabLayout.OnTabClickListener {
            override fun onTabClick(oldTabIndex: Int, newTabIndex: Int) {
                childFragmentManager?.beginTransaction()
                        ?.hide(fragments[oldTabIndex])
                        ?.show(fragments[newTabIndex])
                        ?.commit()
            }
        })

    }

    override fun onDestroy() {
        Log.d("lxx", "destroy ")
        super.onDestroy()

    }

    override fun onDetach() {
        Log.d("lxx", " onDetach ")
        super.onDetach()
    }

    override fun onDestroyView() {
        Log.d("lxx", "onDestroyView ")
        super.onDestroyView()
    }

    override fun initLoad() {
    }

}