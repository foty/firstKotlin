package com.example.foty.mykotlin.project

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
    override fun loadProjectSuccess(data: List<ProjectCategoryBean>) {

    }

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

        //初始化ViewPager与TabLayout
        val viewpagerAdapter = MyViewPagerAdapter(childFragmentManager)

        val fragmentDetails = arrayListOf<ProjectDetailFragment>()
        val titles = arrayListOf<String>()
        titles.add("最新项目")
        titles.add("最好项目")
        titles.add("最热项目")
        fragmentDetails.add(ProjectDetailFragment.newInstance())
        fragmentDetails.add(ProjectDetailFragment.newInstance())
        fragmentDetails.add(ProjectDetailFragment.newInstance())

        viewpagerAdapter.setFragmentsAndTitles(fragmentDetails, titles)
        projectViewPager.adapter = viewpagerAdapter
        //关联viewpager
        projectTabLayout.setupWithViewPager(projectViewPager)

    }

    override fun initLoad() {
    }
}