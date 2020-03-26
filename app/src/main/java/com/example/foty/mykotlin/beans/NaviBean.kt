package com.example.foty.mykotlin.beans

data class NaviBean(val name: String = "",
                    val articles: List<ArticlesItem>?,
                    val cid: Int = 0)