package com.example.foty.mykotlin.adapter

import android.content.Context
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.DataItemBean
import com.example.foty.mykotlin.beans.DatasItem
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/11 14:48
 * Use by
 */
class HomeAdapter(context: Context, datas: List<DatasItem>?, isOpenLoadMore: Boolean)
    : CommonBaseAdapter<DatasItem>(context, datas, isOpenLoadMore) {


    override fun convert(holder: ViewHolder, data: DatasItem, position: Int) {
        with(holder) {

            setText(R.id.articleTitleTv, data.title)
            setText(R.id.articleTimeTv, data.niceDate)

            getView<ImageView>(R.id.articleCollectIv).run {
                if (data.collect) {
                    setImageDrawable(mContext.resources.getDrawable(R.drawable.ic_like_fill))
                } else {
                    setImageDrawable(mContext.resources.getDrawable(R.drawable.ic_like))
                }
            }

            getView<TextView>(R.id.articleTypeTv).run {
                if (data.tags.isNotEmpty()) {
                    text = data.tags[0].name
                    visibility = View.VISIBLE
                } else {
                    visibility = View.GONE
                }
            }
            getView<TextView>(R.id.articleAuthorTv).run {
                if (data.author.isNotEmpty()) {
                    text = data.author
                    visibility = View.VISIBLE
                } else {
                    visibility = View.GONE
                }
            }
        }
    }

    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_article_layout
    }


}