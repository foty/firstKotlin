package com.example.foty.mykotlin.accounts

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.ChapterArticleBean
import com.example.foty.mykotlin.beans.ChapterBean

/**
 * Create by lxx
 * Date : 2020/3/17 14:34
 * Use by
 */
interface AccDetailContract {
    interface View : BaseView {
        fun loadDataSuccess(data: ChapterArticleBean)
    }

    interface Presenter {
        fun getData(cid: Int, pageNum: Int)
    }
}