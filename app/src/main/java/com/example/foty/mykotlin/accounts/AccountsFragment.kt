package com.example.foty.mykotlin.accounts

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.AccountsAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_accounts.*

/**
 * Create by lxx
 * Date : 2020/3/17 14:33
 * Use by
 */
class AccountsFragment : BaseMvpFragment<AccountsPresenter>(), AccountsConstract.View {

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
    }

    override fun initView() {

        val adapter = AccountsAdapter(mContext, null, false)
        chapterRv.layoutManager = GridLayoutManager(mContext, 2)
        chapterRv.adapter = adapter

        val dataList = arrayListOf<String>().apply {
            add("啊哈哈哈")
            add("佛挡杀佛")
            add("问题")
            add("防守打法")
            add("讽德诵功")
            add("发给")
            add("范达瑟")
            add("啊哈但是哈哈")
            add("56656")
            add("瑞")
            add("435个人方法")
        }

        adapter.setNewData(dataList)

    }

    override fun initLoad() {
    }
}