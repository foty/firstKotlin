package com.example.foty.mykotlin.adapter

import android.content.Context
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.DatasItem
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/27 17:07
 * Use by
 */
class SystemDetailAdapter(context: Context, data: ArrayList<DatasItem>?, loadMore: Boolean) :
        CommonBaseAdapter<DatasItem>(context, data, loadMore) {
    override fun getItemLayoutId(): Int {
        return  R.layout.rv_item_tree_layout
    }

    override fun convert(holder: ViewHolder?, data: DatasItem?, position: Int) {
    }
}