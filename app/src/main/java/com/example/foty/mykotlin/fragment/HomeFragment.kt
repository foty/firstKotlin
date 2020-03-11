package com.example.foty.mykotlin.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.adapter.HomeAdapter
import com.example.foty.mykotlin.base.BaseMvpFragment
import com.example.foty.mykotlin.beans.BannerBean
import com.example.foty.mykotlin.beans.DataItemBean
import com.example.foty.mykotlin.utils.ToastUtil
import com.example.foty.mykotlin.view.BannerImageLoader
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Create by lxx
 * Date : 2020/3/10 16:36
 * Use by
 */
class HomeFragment : BaseMvpFragment<HomePresenter>(), HomeContract.View {


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

        val data = DataItemBean("哈哈哈我是tittle", "ioioiio", "码农1号", "3个小时前")

        val dataList = arrayListOf<DataItemBean>().apply {
            add(data)
            add(data)
            add(data)
            add(data)
            add(data)
            add(data)
        }

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter = HomeAdapter(context, dataList, false)
        recyclerView.adapter = adapter
        //列表的点击事件
        adapter.setOnItemClickListener { _, datas, position ->
            ToastUtil.show(context,"你点击了第$position 个，${datas.tittle}")
        }

        //列表下子控件的点击事件
        adapter.setOnItemChildClickListener(R.id.articleCollectIv) { _, data1, position ->
            data1.like = !data1.like
            adapter.change(position)
            ToastUtil.show(context, "收藏成功")
        }


    }

    override fun initLoad() {
    }
}