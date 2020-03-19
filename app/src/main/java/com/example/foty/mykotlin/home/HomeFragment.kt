package com.example.foty.mykotlin.home

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.HomeAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.ArticleBean
import com.example.foty.mykotlin.beans.BannerBean
import com.example.foty.mykotlin.beans.DataItemBean
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.view.BannerImageLoader
import com.othershe.baseadapter.interfaces.OnLoadMoreListener
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Create by lxx
 * Date : 2020/3/10 16:36
 * Use by home模块
 */
class HomeFragment : BaseMvpFragment<HomePresenter>(), HomeContract.View {

    private var pageNum: Int = 0
    private lateinit var adapter: HomeAdapter
    private lateinit var bannerBeans: List<BannerBean>
    private lateinit var banner: Banner


    override fun initPresenter(): HomePresenter {
        return HomePresenter(this)
    }

    /**
     * 静态方法
     */
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutResID(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        presenter.getArticleList(pageNum)
    }

    override fun initView() {
        //添加轮播图片
        banner = LayoutInflater.from(mContext).inflate(R.layout.home_banner_layout,
                homeRootView, false) as Banner
        banner.run {
            setDelayTime(3000)
            setImageLoader(BannerImageLoader())
            setIndicatorGravity(BannerConfig.RIGHT)
            setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
            setOnBannerListener {
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = HomeAdapter(context, null, true)

        adapter.run {

        setLoadingView(R.layout.rv_loading_layout)
//        setLoadEndView(R.layout.rv_load_end_layout)
//        setLoadFailedView(R.layout.rv_load_failed_layout)

            //列表的点击事件
            setOnItemClickListener { _, datas, position ->
                ToastUtil.show(context, "你点击了第$position 个，${datas.title}")
            }

            //列表下子控件的点击事件
            setOnItemChildClickListener(R.id.articleCollectIv) { _, data1, position ->
                data1.collect = !data1.collect
                adapter.change(position)
                ToastUtil.show(context, "收藏成功")
            }

            setOnLoadMoreListener {
                presenter.getArticleList(pageNum)
            }
        }
        //要等adapter所有属性设置完毕再赋值给recyclerView(否则会出现意想不到的情况)
        recyclerView.adapter = adapter

    }

    override fun loadArticleListSuccess(data: ArticleBean) {
        if (pageNum == 0) {
            adapter.setNewData(data.datas)
        } else {
            adapter.setLoadMoreData(data.datas)
        }
        pageNum++

        if (pageNum == data.pageCount) {
            adapter.loadEnd()
            return
        }
    }

    override fun initLoad() {
    }
}