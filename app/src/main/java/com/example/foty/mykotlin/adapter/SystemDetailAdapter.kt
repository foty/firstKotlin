package com.example.foty.mykotlin.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
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
        return R.layout.rv_item_tree_detail_layout
    }

    override fun convert(holder: ViewHolder, data: DatasItem, position: Int) {

        holder.setText(R.id.articleTitleTv, data.title)
        holder.setText(R.id.articleTimeTv, data.niceDate)
        holder.getView<TextView>(R.id.articleAuthorTv).apply {
            text = when {
                TextUtils.isEmpty(data.author) -> "未知名作者"
                else -> data.author
            }
        }

        holder.getView<ImageView>(R.id.treeArticleCollectIv).apply {
            setImageResource(when {
                data.collect -> R.drawable.ic_like_fill
                else -> R.drawable.ic_like

            })
        }

    }
}