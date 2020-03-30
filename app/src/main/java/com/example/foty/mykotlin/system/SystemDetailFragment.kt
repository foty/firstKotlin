package com.example.foty.mykotlin.system

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.SystemDetailAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.DatasItem
import com.example.foty.mykotlin.beans.TreeDetailBean
import com.example.foty.mykotlin.home.ArticleWebActivity
import kotlinx.android.synthetic.main.fragment_system_detail.*

/**
 * Create by lxx
 * Date : 2020/3/27 15:31
 * Use by
 */
class SystemDetailFragment : BaseMvpFragment<SystemDetailPresenter>(), SystemDetailContract.View {

    private lateinit var adapter: SystemDetailAdapter
    private var pageNum: Int = 0
    private var cid: Int = -1

    companion object {
        fun newInstance(id: Int): SystemDetailFragment {
            val f = SystemDetailFragment()
            f.arguments = Bundle().apply {
                putInt("cid", id)
            }
            return f
        }
    }

    override fun initPresenter(): SystemDetailPresenter {
        return SystemDetailPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_system_detail
    }

    override fun initData() {
        cid = arguments.getInt("cid")
        if (cid < 0) return
        presenter.getDatas(pageNum, cid)

    }

    override fun initView() {

        adapter = SystemDetailAdapter(mContext, null, true).apply {
            setLoadingView(R.layout.rv_loading_layout)
            setOnItemChildClickListener(R.id.treeArticleCollectIv) { _, data, position ->
                data.collect = !data.collect
                adapter.notifyItemChanged(position)
            }

            setOnItemClickListener { _, data, _ ->
                ArticleWebActivity.startActivity(mContext,data.link)
            }

            setOnLoadMoreListener {
                presenter.getDatas(pageNum, cid)
            }
        }
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter
    }

    override fun initLoad() {
    }

    override fun loadDataSuccess(data: TreeDetailBean) {
        if (pageNum == 0) {
            adapter.setNewData(data.datas)
        } else {
            adapter.setLoadMoreData(data.datas)
        }
        pageNum++
        if (pageNum == data.pageCount) {
            adapter.loadEnd()
            return
        }
    }
}