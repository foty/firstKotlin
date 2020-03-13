package com.example.foty.mykotlin.adapter

import android.content.Context
import android.widget.TextView
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.SystemBean
import com.google.android.flexbox.FlexboxLayout
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/13 15:24
 * Use by
 */
class SystemAdapter(context: Context, datas: List<SystemBean>?, loadMore: Boolean)
    : CommonBaseAdapter<SystemBean>(context, datas, loadMore) {

    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_tree_layout
    }

    override fun convert(holder: ViewHolder, itemBean: SystemBean, position: Int) {
        with(holder){
            setText(R.id.treeTitleTv, itemBean.tittle)
            setTreeData(mContext, getView(R.id.treeFL), itemBean.context)
        }
    }

    private fun setTreeData(mContext: Context?, flexView: FlexboxLayout, str: String) {
        for (text in 1..5){
            val view = TextView(mContext)
            view.text = str
            flexView.addView(view)
        }
    }
}