package com.example.foty.mykotlin.adapter

import android.content.Context
import android.widget.TextView
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.beans.DataItemBean
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter

/**
 * Create by lxx
 * Date : 2020/3/12 14:03
 * Use by
 */
class ProjectDetailAdapter(context: Context, datas: List<DataItemBean>?, loadMore: Boolean)
    : CommonBaseAdapter<DataItemBean>(context, datas, loadMore) {

    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_project_layout
    }

    override fun convert(holder: ViewHolder, itemBean: DataItemBean, position: Int) {

        with(holder) {

            getView<TextView>(R.id.projectTitleTv).run {
                text = itemBean.tittle
            }

            getView<TextView>(R.id.projectAuthorTv).run {
                text = itemBean.author
            }
            getView<TextView>(R.id.projectTimeTv).run {
                text = itemBean.time
            }
            getView<TextView>(R.id.projectDescTv).run {
                text = itemBean.desc
            }
        }

    }
}