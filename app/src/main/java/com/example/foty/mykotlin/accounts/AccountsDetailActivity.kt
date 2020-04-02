package com.example.foty.mykotlin.accounts

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.AccountsDetailAdapter
import com.example.foty.mykotlin.base.BaseActivity
import com.example.foty.mykotlin.base.BaseMvpActivity
import com.example.foty.mykotlin.beans.ChapterArticleBean
import com.example.foty.mykotlin.beans.ChapterBean
import kotlinx.android.synthetic.main.activity_acc_details.*
import kotlinx.android.synthetic.main.home_banner_layout.*

/**
 * Create by lxx
 * Date : 2020/4/2 17:26
 * Use by
 */
class AccountsDetailActivity : BaseMvpActivity<AccsDetailPresenter>(), AccDetailContract.View {
    private lateinit var adapter: AccountsDetailAdapter
    private var pageNum: Int = 0
    private var cId: Int = 0


    companion object {
        fun startActivity(activity: BaseActivity, id: Int) {
            var intent = Intent(activity, AccountsDetailActivity::class.java).apply {
                putExtra("id", id)
            }

            activity.startActivity(intent)
        }
    }

    override fun initPresenter(): AccsDetailPresenter {
        return AccsDetailPresenter(this)
    }

    override fun initLayoutResID(): Int {
        return R.layout.activity_acc_details
    }

    override fun initData() {
        if (cId < 0) return
        presenter.getData(cId, pageNum)
    }

    override fun initView() {

        //优雅地处理空问题
        intent?.let {
            cId = it.getIntExtra("id", -1)
        }

        recyclerView.layoutManager = LinearLayoutManager(mContext)
        adapter = AccountsDetailAdapter(mContext, null, true).apply {
            setLoadingView(R.layout.rv_loading_layout)
            setOnItemClickListener { viewHolder, chapterBean, i ->

            }


        }
        recyclerView.adapter = adapter

    }

    override fun loadDataSuccess(data: ChapterArticleBean) {
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