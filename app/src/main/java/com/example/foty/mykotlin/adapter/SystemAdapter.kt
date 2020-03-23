package com.example.foty.mykotlin.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.ChildrenItem
import com.example.foty.mykotlin.beans.SystemBean
import com.example.foty.mykotlin.beans.TreeBean
import com.example.foty.mykotlin.utils.CommonUtil
import com.google.android.flexbox.FlexboxLayout
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/13 15:24
 * Use by
 */
class SystemAdapter(context: Context, datas: List<TreeBean>?, loadMore: Boolean)
    : CommonBaseAdapter<TreeBean>(context, datas, loadMore) {

    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_tree_layout
    }

    override fun convert(holder: ViewHolder, itemBean: TreeBean, position: Int) {
        with(holder) {
            setText(R.id.treeTitleTv, itemBean.name)
            setTreeData(mContext, getView(R.id.treeFL), itemBean.children)
        }
    }

    private fun setTreeData(mContext: Context, flexView: FlexboxLayout, datalist: ArrayList<ChildrenItem>) {
        if (flexView.childCount != 0) {
            flexView.removeAllViews()
        }
        for (item in datalist) {
            val view = TextView(mContext)
            view.text = item.name
            view.setTextColor(mContext.resources.getColor(R.color.c8A8A8A))
            val params = FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            val margin1 = CommonUtil.dp2px(mContext, 3)
            val margin2 = CommonUtil.dp2px(mContext, 15)
            params.setMargins(0, margin1, margin2, margin1)
            flexView.addView(view,params)
        }
    }
}