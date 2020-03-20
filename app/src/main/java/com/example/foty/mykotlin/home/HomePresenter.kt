package com.example.foty.mykotlin.home

import android.util.Log
import com.example.foty.mykotlin.base.BasePresenter
import com.example.foty.mykotlin.beans.ArticleBean
import com.example.foty.mykotlin.beans.BannerBean
import com.example.foty.mykotlin.net.*

/**
 * Create by lxx
 * Date : 2020/3/11 10:25
 * Use by
 */
class HomePresenter(view: HomeContract.View) : BasePresenter<HomeContract.View>(view), HomeContract.Presenter {

    override fun getArticleList(pageNum: Int) {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).articleList(pageNum),
                object : BaseObserver<ArticleBean>() {
                    override fun onSuccess(data: ArticleBean) {
                        view.loadArticleListSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                    }
                })
    }

    override fun getBannerData() {
        RequestManager.execute(this, RetrofitManager.create(WanAndroidApis::class.java).banner(),
                object : BaseObserver<List<BannerBean>>() {
            override fun onSuccess(data: List<BannerBean>) {
                view.loadBannerSuccess(data)
            }

            override fun onError(e: ResponseException) {
            }
        })

    }


}