package com.example.foty.mykotlin.main

import android.util.Log
import com.example.foty.mykotlin.R
import com.example.foty.mykotlin.base.BaseMvpActivity
import java.util.*

class MainActivity : BaseMvpActivity<MainPresenter>(), MainContract.View {

    override fun onLogoutSuccess(data: String) {
    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun initLayoutResID(): Int = R.layout.activity_main

    override fun initData() {
        add(1, 2, 3)
        add(1, 2, 3, 4)
    }

    override fun initView() {
    }

    override fun initLoad() {
    }

    private fun add(x: Int, y: Int, z: Int, q: Int = 0) {

    }

    //List是有序容器，通过listOf创建，不过创建出来好像是只读序列，读写数组需要用MutableList显式修饰
    fun switch(x: Int): Int {
        var list = listOf("1", "2", "3")
        var list2: MutableList<String> = ArrayList()
        list2.add("666")
        list2.add("666")
        list2.add("666")
        list2.add("666")
        list2.remove("66667")
        list2.removeAt(3)

        for (i in list2.indices) {
            Log.d("TPA", "测试提交")
        }

        var stringArr = emptyArray<Int>()
        stringArr[2] = 2
        return 110
    }
}
