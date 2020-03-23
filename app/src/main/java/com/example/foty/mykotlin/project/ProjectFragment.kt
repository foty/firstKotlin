package com.example.foty.mykotlin.project

import android.util.Log
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.MyViewPagerAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.ProjectCategoryBean
import kotlinx.android.synthetic.main.fragment_project.*

/**
 * Create by lxx
 * Date : 2020/3/11 17:35
 * Use by 项目模块
 */
class ProjectFragment : BaseMvpFragment<ProjectPresenter>(), ProjectContract.View {

    companion object {
        fun newInstance() = ProjectFragment()
    }


    override fun initPresenter(): ProjectPresenter {
        return ProjectPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_project
    }

    override fun initData() {
        presenter.getProjectList()
    }

    override fun initView() {

    }

    override fun loadProjectSuccess(data: List<ProjectCategoryBean>) {

        val fragmentDetails = arrayListOf<ProjectDetailFragment>()
        val titles = arrayListOf<String>()
        for (item in data) {
            titles.add(item.name)
            fragmentDetails.add(ProjectDetailFragment.newInstance(item.id))
        }
        //初始化ViewPager与TabLayout
        val viewpagerAdapter = MyViewPagerAdapter(childFragmentManager)
        viewpagerAdapter.setFragmentsAndTitles(fragmentDetails, titles)
        projectViewPager.adapter = viewpagerAdapter
        //关联viewpager
        projectTabLayout.setupWithViewPager(projectViewPager)
    }

    override fun initLoad() {
    }
}