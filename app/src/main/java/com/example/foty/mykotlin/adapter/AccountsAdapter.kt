package com.example.foty.mykotlin.adapter

import android.content.Context
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.ChapterBean
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/17 14:42
 * Use by
 */
class AccountsAdapter(context: Context, list: List<ChapterBean>?, loadMore: Boolean)
    : CommonBaseAdapter<ChapterBean>(context, list, loadMore) {

    private val colors = intArrayOf(R.color.c9DD3FA, R.color.cF7F7D0,
            R.color.cFFC09F, R.color.cA0D8DE, R.color.cE2DBBE, R.color.cEAE1F0)

    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_chapter_layout
    }

    override fun convert(holder: ViewHolder, item: ChapterBean, position: Int) {

        with(holder) {
            setText(R.id.chapterNameTv, item.name)
            setBgColor(R.id.chapterNameTv, mContext.resources.getColor(colors[position % 6]))
        }
    }
}