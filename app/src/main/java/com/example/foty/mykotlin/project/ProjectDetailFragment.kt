package com.example.foty.mykotlin.project

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.ProjectDetailAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.DataItemBean
import com.example.foty.mykotlin.beans.ProjectBean
import com.example.foty.mykotlin.home.ArticleWebActivity
import com.example.foty.mykotlin.utils.ToastUtil
import kotlinx.android.synthetic.main.fragment_project_detail.*

/**
 * Create by lxx
 * Date : 2020/3/12 11:39
 * Use by
 */
class ProjectDetailFragment : BaseMvpFragment<ProjectDetailPresenter>(), ProjectDetailConstract.View {

    private lateinit var adapter: ProjectDetailAdapter
    private var pageNum: Int = 0
    private var cid: Int = -1

    companion object {
        fun newInstance(cid: Int): ProjectDetailFragment {

            val f = ProjectDetailFragment()
            val bundle = Bundle()
            bundle.putInt("cid", cid)
            f.arguments = bundle
            return f
        }
    }

    override fun initPresenter(): ProjectDetailPresenter {
        return ProjectDetailPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_project_detail
    }

    override fun initData() {
        presenter.getDetailArticle(pageNum, cid)
    }

    override fun initView() {

        cid = arguments.getInt("cid")


        adapter = ProjectDetailAdapter(mContext, null, true)
        projectRv.layoutManager = LinearLayoutManager(mContext)
        adapter.setLoadingView(R.layout.rv_loading_layout)
        adapter.setOnLoadMoreListener {
            presenter.getDetailArticle(pageNum, cid)
        }
        adapter.run {
            setOnItemClickListener { _, data, _ ->
                ArticleWebActivity.startActivity(mContext, data.link)
            }

            setOnItemChildClickListener(R.id.projectCollectIv) { _, data, _ ->
                ToastUtil.show(mContext, data.author)
            }
        }

        projectRv.adapter = adapter
    }

    override fun loadDetailSuccess(data: ProjectBean) {
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


    override fun initLoad() {
    }
}