package com.example.foty.mykotlin

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
//        LitePal.initialize(this)
    }

    companion object {
        private lateinit var instance: App
        fun getApp(): App {
            return instance
        }
    }
}