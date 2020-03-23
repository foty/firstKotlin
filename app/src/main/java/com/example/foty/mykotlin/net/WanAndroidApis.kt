package com.example.foty.mykotlin.net

import com.example.foty.mykotlin.beans.*
import io.reactivex.Observable
import retrofit2.http.*

interface WanAndroidApis {
    /**
     * 登录
     */
    @POST("user/login")
    fun login(@QueryMap param: Map<String, String>): Observable<BaseResponse<DataItemBean>>

    /**
     * 注册
     */
    @POST("user/register")
    fun register(@QueryMap param: Map<String, String>): Observable<BaseResponse<DataItemBean>>

    /**
     * 退出
     */
    @GET("user/logout/json")
    fun logout(): Observable<BaseResponse<String>>

    /**
     * 首页banner
     */
    @GET("banner/json")
    fun banner(): Observable<BaseResponse<List<BannerBean>>>

    /**
     * 常用网站
     */
    @GET("friend/json")
    fun friend(): Observable<BaseResponse<List<DataItemBean>>>

    /**
     * 首页文章列表
     */
    @GET("article/list/{pageNum}/json")
    fun articleList(@Path("pageNum") pageNum: Int): Observable<BaseResponse<ArticleBean>>

    /**
     * 热词（目前搜索最多的关键词）
     */
    @GET("/hotkey/json")
    fun hotKey(): Observable<BaseResponse<List<DataItemBean>>>

    /**
     * 搜索（支持多个关键词，用空格隔开）
     */
    @POST("article/query/{pageNum}/json")
    fun query(@Path("pageNum") pageNum: Int, @Query("k") k: String): Observable<BaseResponse<DataItemBean>>

    /**
     * 体系结构
     */
    @GET("tree/json")
    fun tree(): Observable<BaseResponse<List<TreeBean>>>

    /**
     * 体系下的文章
     */
    @GET("article/list/{pageNum}/json")
    fun treeDetail(@Path("pageNum") pageNum: Int, @Query("cid") cid: Int): Observable<BaseResponse<DataItemBean>>

    /**
     * 最新项目
     */
    @GET("article/listproject/{pageNum}/json")
    fun newProject(@Path("pageNum") pageNum: Int): Observable<BaseResponse<DataItemBean>>

    /**
     * 项目分类
     */
    @GET("project/tree/json")
    fun projectCategory(): Observable<BaseResponse<List<ProjectCategoryBean>>>


    /**
     * 项目分类详情列表
     */
    @GET("project/list/{pageNum}/json")
    fun projectDetail(@Path("pageNum") pageNum: Int, @Query("cid") cid: Int): Observable<BaseResponse<ProjectBean>>


    /**
     * 导航
     */
    @GET("navi/json")
    fun nav(): Observable<BaseResponse<List<DataItemBean>>>

    /**
     * 微信公众号列表
     */
    @GET("wxarticle/chapters/json")
    fun chapter(): Observable<BaseResponse<List<ChapterBean>>>

    /**
     * 微信公众号文章列表
     */
    @GET("wxarticle/list/{chapterId}/{pageNum}/json")
    fun chapterArticleList(@Path("chapterId") chapterId: Int,
                           @Path("pageNum") pageNum: Int): Observable<BaseResponse<DataItemBean>>

    /**
     * 微信公众号文章搜索
     */
    @GET("wxarticle/list/{chapterId}/{pageNum}/json")
    fun queryChapterArticle(@Path("chapterId") chapterId: Int, @Path("pageNum") pageNum: Int,
                            @Query("k") k: String): Observable<BaseResponse<DataItemBean>>

    /**
     * 收藏文章列表
     */
    @GET("lg/collect/list/{pageNum}/json")
    fun collectArticleList(@Path("pageNum") pageNum: Int): Observable<BaseResponse<DataItemBean>>

    /**
     * 收藏站内文章
     */
    @POST("lg/collect/{id}/json")
    fun collectArticle(@Path("id") id: Int): Observable<BaseResponse<String>>

    /**
     * 在文章列表取消收藏
     */
    @POST("lg/uncollect_originId/{id}/json")
    fun uncollectArticle(@Path("id") id: Int): Observable<BaseResponse<String>>

    /**
     * 在收藏列表取消收藏
     */
    @POST("lg/uncollect/{id}/json")
    fun cancelMyCollection(@Path("id") id: Int, @Query("originId") originId: Int): Observable<BaseResponse<String>>
}