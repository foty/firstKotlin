package com.example.foty.mykotlin.project

import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseMvpFragment

/**
 * Create by lxx
 * Date : 2020/3/12 11:39
 * Use by
 */
class ProjectDetailFragment : BaseMvpFragment<ProjectDetailPresenter>(), ProjectDetailConstract.View {

    companion object {
        fun newInstance() = ProjectDetailFragment()
    }

    override fun initPresenter(): ProjectDetailPresenter {
        return ProjectDetailPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_project_detail
    }


    override fun initData() {
    }

    override fun initView() {
    }

    override fun initLoad() {
    }
}