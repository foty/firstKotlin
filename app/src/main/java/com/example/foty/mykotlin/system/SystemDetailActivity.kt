package com.example.foty.mykotlin.system

import android.content.Intent
import android.support.design.widget.TabLayout
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.MyViewPagerAdapter
import com.example.foty.mykotlin.base.BaseActivity
import com.example.foty.mykotlin.beans.ChildrenItem
import kotlinx.android.synthetic.main.activity_system_detail.*
import kotlinx.android.synthetic.main.fragment_project.*

/**
 * Create by lxx
 * Date : 2020/3/27 16:24
 * Use by
 */
class SystemDetailActivity : BaseActivity() {


    companion object {

        fun startActivity(activity: BaseActivity, list: ArrayList<ChildrenItem>) {
            val intent = Intent(activity, SystemDetailActivity::class.java)
            intent.putParcelableArrayListExtra("data", list)
            activity.startActivity(intent)
        }
    }

    override fun initLayoutResID(): Int {
        return R.layout.activity_system_detail
    }

    override fun initData() {
    }

    override fun initView() {

        val list = intent.getParcelableArrayListExtra<ChildrenItem>("data")

        val fragmentDetails = arrayListOf<SystemDetailFragment>()
        val titles = arrayListOf<String>()
        for (item in list) {
            titles.add(item.name)
            fragmentDetails.add(SystemDetailFragment.newInstance(item.id))
        }
        val viewpagerAdapter = MyViewPagerAdapter(supportFragmentManager)
        viewpagerAdapter.setFragmentsAndTitles(fragmentDetails, titles)
        viewPager.adapter = viewpagerAdapter
        //关联viewpager
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun initLoad() {
    }
}