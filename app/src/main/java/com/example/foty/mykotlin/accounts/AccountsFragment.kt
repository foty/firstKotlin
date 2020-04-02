package com.example.foty.mykotlin.accounts

import android.support.v7.widget.GridLayoutManager
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.AccountsAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.ChapterBean
import com.example.foty.mykotlin.utils.ToastUtil
import kotlinx.android.synthetic.main.fragment_accounts.*

/**
 * Create by lxx
 * Date : 2020/3/17 14:33
 * Use by
 */
class AccountsFragment : BaseMvpFragment<AccountsPresenter>(), AccountsContract.View {
    private lateinit var adapter: AccountsAdapter

    companion object {
        fun newInstance(): AccountsFragment = AccountsFragment()
    }

    override fun initPresenter(): AccountsPresenter {
        return AccountsPresenter(this)
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_accounts
    }

    override fun initData() {
        presenter.getData()
    }

    override fun initView() {

        adapter = AccountsAdapter(mContext, null, false)
        chapterRv.layoutManager = GridLayoutManager(mContext, 2)
        chapterRv.adapter = adapter
        adapter.setOnItemClickListener { _, chapterBean, _ ->

            AccountsDetailActivity.startActivity(mContext,chapterBean.id)
        }

    }

    override fun loadDataSuccess(data: List<ChapterBean>) {
        adapter.setNewData(data)
    }


    override fun initLoad() {
    }
}