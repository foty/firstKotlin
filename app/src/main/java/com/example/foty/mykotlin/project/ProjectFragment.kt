package com.example.foty.mykotlin.project

import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseMvpFragment

/**
 * Create by lxx
 * Date : 2020/3/11 17:35
 * Use by
 */
class ProjectFragment : BaseMvpFragment<ProjectPresenter>(), ProjectConstract.View {

    companion object{
        fun newInstance() = ProjectFragment()
    }


    override fun initPresenter(): ProjectPresenter {
        return ProjectPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_project
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun initLoad() {
    }
}