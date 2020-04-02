package com.example.foty.mykotlin.accounts

import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.ChapterArticleBean
import com.example.foty.mykotlin.beans.ChapterBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/17 14:34
 * Use by
 */
class AccsDetailPresenter(view: AccDetailContract.View) : BasePresenter<AccDetailContract.View>(view), AccDetailContract.Presenter {

    override fun getData(cid: Int, pageNum: Int) {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).chapterArticleList(cid,pageNum)
                , object : BaseObserver<ChapterArticleBean>() {
            override fun onError(e: ResponseException) {

            }

            override fun onSuccess(data: ChapterArticleBean) {
                view.loadDataSuccess(data)
            }
        })
    }
}