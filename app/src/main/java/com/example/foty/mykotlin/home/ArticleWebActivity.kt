package com.example.foty.mykotlin.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_article.*
import java.time.Instant

/**
 * Create by lxx
 * Date : 2020/3/20 15:17
 * Use by
 */
class ArticleWebActivity : BaseActivity() {

    private lateinit var url: String

    companion object {
        fun startActivity(activity: BaseActivity, url: String) {
            val intent = Intent(activity, ArticleWebActivity::class.java)
            intent.run {
                putExtra("url", url)
            }
            activity.startActivity(intent)
        }
    }

    override fun initLayoutResID(): Int {
        return R.layout.activity_article
    }

    override fun initData() {
        url = intent.getStringExtra("url")
        articleWebView.loadUrl(url)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        articleWebView.settings.run {
            setSupportZoom(true)
            javaScriptEnabled = true
            displayZoomControls = false
            builtInZoomControls = true
        }


    }

    override fun initLoad() {
    }
}