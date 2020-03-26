package com.example.foty.mykotlin.main

import android.util.Log
import android.view.Gravity
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.accounts.AccountsFragment
import com.example.foty.mykotlin.adapter.MyViewPagerAdapter
import com.example.foty.mykotlin.base.BaseFragment
import com.example.foty.mykotlin.base.BaseMvpActivity
import com.example.foty.mykotlin.home.HomeFragment
import com.example.foty.mykotlin.navigation.NavigationFragment
import com.example.foty.mykotlin.project.ProjectFragment
import com.example.foty.mykotlin.system.SystemFragment
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.view.BottomTabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseMvpActivity<MainPresenter>(), MainContract.View {

    override fun onLogoutSuccess(data: String) {
    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun initLayoutResID(): Int = R.layout.activity_main

    override fun initData() {
        add(1, 2, 3)
        add(1, 2, 3, 4)
    }

    override fun initView() {
        mainMenuIv.setOnClickListener {
            drawerLayout.openDrawer(Gravity.START)
        }
        mainQueryIv.setOnClickListener {
            ToastUtil.show(this, "暂时没有什么发现")
        }

        navigation_view_left.setNavigationItemSelectedListener {
            //when 表达式，替换了java下的switch
            when (it.itemId) {
                R.id.nav_item_about -> ToastUtil.show(mContext, "1111")
                R.id.nav_item_collect -> ToastUtil.show(mContext, "2222")
                R.id.nav_item_logout -> ToastUtil.show(mContext, "3333")
                R.id.nav_item_setting -> exit()
            }
            return@setNavigationItemSelectedListener true
        }


        //高级函数 let with run apply also
        val list = arrayListOf<BaseFragment>().apply {
            add(HomeFragment.newInstance())
            add(ProjectFragment.newInstance())
            add(SystemFragment.newInstance())
            add(NavigationFragment.newInstance())
            add(AccountsFragment.newInstance())
        }

        val pagerAdapter = MyViewPagerAdapter(supportFragmentManager)
        pagerAdapter.setFragments(list)
        mainViewpager.adapter = pagerAdapter

        mainBottomTabLayout.setupWithViewPager(mainViewpager)
        mainBottomTabLayout.setOnTabSwitchListener(object : BottomTabLayout.OnTabSwitchListener{
            override fun onTabSwitch(tabIndex: Int, tabName: String) {

            }
        })
        mainBottomTabLayout.addTab("首页",R.drawable.ic_homepage,R.drawable.ic_homepage_fill)
        mainBottomTabLayout.addTab("项目",R.drawable.ic_createtask,R.drawable.ic_createtask_fill)
        mainBottomTabLayout.addTab("体系",R.drawable.ic_manage,R.drawable.ic_manage_fill)
        mainBottomTabLayout.addTab("导航",R.drawable.ic_coordinates,R.drawable.ic_coordinates_fill)
        mainBottomTabLayout.addTab("公众号",R.drawable.ic_select,R.drawable.ic_select_fill)

    }

    override fun initLoad() {
    }

    fun exit(){
        finish()
    }

    private fun add(x: Int, y: Int, z: Int, q: Int = 0) {

    }

    //List是有序容器，通过listOf创建，不过创建出来好像是只读序列，读写数组需要用MutableList显式修饰
    fun switch(x: Int): Int {
        var list = listOf("1", "2", "3")
        var list2: MutableList<String> = ArrayList()
        list2.add("666")
        list2.add("666")
        list2.add("666")
        list2.add("666")
        list2.remove("66667")
        list2.removeAt(3)

        for (i in list2.indices) {
            Log.d("TPA", "测试提交")
        }

        var stringArr = emptyArray<Int>()
        stringArr[2] = 2
        return 110
    }
}
