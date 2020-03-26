package com.example.foty.mykotlin.navigation

import android.util.Log
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseFragment
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.ArticlesItem
import com.example.foty.mykotlin.beans.NaviBean
import com.example.foty.mykotlin.view.VerticalTabLayout
import kotlinx.android.synthetic.main.fragment_navigation.*

/**
 * Created by PlaceHolder on 2020/3/15.
 * use to :
 */
class NavigationFragment : BaseMvpFragment<NavigationPresenter>(), NavigationContract.View {

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
        presenter.getNavData()
    }

    override fun initView() {

    }

    override fun lodaDataSuccess(data: List<NaviBean>) {
        val tabList = arrayListOf<String>()

        for (item in data){
            fragments.add(NavFragmentDetail.newInstance(item.articles as ArrayList<ArticlesItem> ))
            tabList.add(item.name)
        }

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

    override fun initLoad() {
    }

}