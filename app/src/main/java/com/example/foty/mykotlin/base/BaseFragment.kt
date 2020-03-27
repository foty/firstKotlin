package com.example.foty.mykotlin.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.foty.mykotlin.R

/**
 * Create by lxx
 * Date : 2020/3/9 15:06
 * Use by
 */
abstract class BaseFragment : Fragment() {

    lateinit var mContext: BaseActivity
    lateinit var rootView: View
    lateinit var progress: View

    private var isViewCreated: Boolean = false // 界面是否已创建完成
    protected var isVisibleToUser: Boolean = false // 是否对用户可见
    private var isDataLoaded: Boolean = false// 数据是否已请求, isNeedReload()返回false的时起作用
    private var isFragmentHidden: Boolean = true // 记录当前fragment的是否隐藏


    private var isShowing: Boolean = false
    private var loadAgain : Boolean = false

    @LayoutRes
    abstract fun getLayoutResID(): Int

    abstract fun initData()

    abstract fun initView()

    abstract fun initLoad()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context as BaseActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = LayoutInflater.from(mContext).inflate(getLayoutResID(), container, false)

        progress = LayoutInflater.from(mContext).inflate(R.layout.view_loading, container, false)

        return rootView
//        return inflater.inflate(getLayoutResID(),container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isViewCreated = true
        initData()

    }

    override fun onDestroy() {
        loadAgain = true
        super.onDestroy()
    }

    /**
     * viewpager滑动切换回调该方法
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
//        Log.d("lxx", "setUserVisibleHint  $isVisibleToUser")
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isViewCreated && loadAgain) {
//            initData()
        }
    }


    /**
     * 使用show()、hide()控制fragment显示、隐藏时回调该方法
     */
    override fun onHiddenChanged(hidden: Boolean) {
//        Log.d("lxx", "onHiddenChanged $hidden")
    }

    open fun showProgress() {
        if (rootView is ViewGroup) {
            (rootView as ViewGroup).addView(progress, 0)
            isShowing = true
        }
    }

    open fun hideProgress() {
        if (rootView is ViewGroup) {
            (rootView as ViewGroup).removeView(progress)
            isShowing = false
        }
    }

    open fun isShowing() = isShowing
}