package com.example.foty.mykotlin.home

import com.example.foty.mykotlin.base.BaseView
import com.example.foty.mykotlin.beans.ArticleBean
import com.example.foty.mykotlin.beans.BannerBean

/**
 * Create by lxx
 * Date : 2020/3/11 10:29
 * Use by
 */
interface HomeContract {

    interface View : BaseView {

        fun loadArticleListSuccess(data: ArticleBean)

        fun loadBannerSuccess(data: List<BannerBean>)
    }

    interface Presenter {

        /**
         * 获取轮播图片
         */
        fun getBannerData()

        /**
         * 获取文章列表
         */
        fun getArticleList(pageNum : Int)

    }
}