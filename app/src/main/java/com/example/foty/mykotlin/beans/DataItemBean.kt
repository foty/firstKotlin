package com.example.foty.mykotlin.beans

/**
 * Create by lxx
 * Date : 2020/3/11 14:50
 * Use by
 */
data class DataItemBean(val tittle: String, val type: String,
                        val author: String, val time: String,
                        val desc : String = "",
                        var like: Boolean = false)