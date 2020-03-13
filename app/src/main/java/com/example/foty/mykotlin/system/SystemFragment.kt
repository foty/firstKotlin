package com.example.foty.mykotlin.system

import android.support.v7.widget.LinearLayoutManager
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.SystemAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.SystemBean
import com.example.foty.mykotlin.view.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_system.*

/**
 * Create by lxx
 * Date : 2020/3/13 15:14
 * Use by
 */
class SystemFragment : BaseMvpFragment<SystemPresenter>(), SystemConstract.View {

    companion object {
        fun newInstance(): SystemFragment {
            return SystemFragment()
        }
    }

    override fun initPresenter(): SystemPresenter {
        return SystemPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_system
    }

    override fun initData() {
    }

    override fun initView() {
        treeRv.layoutManager = LinearLayoutManager(mContext)
        val adapter = SystemAdapter(mContext, null, false)
        treeRv.addItemDecoration(DividerItemDecoration()
                .setDividerHeight(20)
                .setDividerColor(resources.getColor(R.color.cEEEEF5)))
        treeRv.adapter = adapter

        val systemBean = SystemBean("哈哈哈哈", "兄弟6啊    ")
        val list = arrayListOf<SystemBean>()

        for (i in 1..25) {
            list.add(systemBean)
        }
        adapter.setNewData(list)

    }

    override fun initLoad() {
    }
}