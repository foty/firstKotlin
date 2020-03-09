package com.example.foty.mykotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Create by lxx
 * Date : 2020/3/9 11:07
 * Use by
 */
abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutResID())
        mContext = this
        initView()
        initData()
        initLoad()
    }

    abstract fun initLayoutResID(): Int

    abstract fun initData()

    abstract fun initView()

    abstract fun initLoad()
}