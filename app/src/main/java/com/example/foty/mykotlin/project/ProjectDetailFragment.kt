package com.example.foty.mykotlin.project

import android.support.v7.widget.LinearLayoutManager
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.ProjectDetailAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.DataItemBean
import kotlinx.android.synthetic.main.fragment_project_detail.*

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

        val adapter = ProjectDetailAdapter(mContext,null,false)
        projectRv.layoutManager = LinearLayoutManager(mContext)
        projectRv.adapter = adapter

        val data = DataItemBean("哈哈哈我是tittle", "ioioiio", "码农1号", "3个小时前","啦啦啦啦啦啦啦")
        val dataList = arrayListOf<DataItemBean>().apply {
            add(data)
            add(data)
            add(data)
            add(data)
            add(data)
            add(data)
        }
        adapter.setNewData(dataList)

    }

    override fun initLoad() {
    }
}