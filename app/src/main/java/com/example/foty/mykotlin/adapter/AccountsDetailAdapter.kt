package com.example.foty.mykotlin.adapter

import android.content.Context
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.ChapterBean
import com.example.foty.mykotlin.beans.DatasItem
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/17 14:42
 * Use by
 */
class AccountsDetailAdapter(context: Context, list: List<DatasItem>?, loadMore: Boolean)
    : CommonBaseAdapter<DatasItem>(context, list, loadMore) {



    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_chapter_layout
    }

    override fun convert(holder: ViewHolder, item: DatasItem, position: Int) {

        with(holder) {
        }
    }
}