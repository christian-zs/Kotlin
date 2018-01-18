package com.example.zs.kotlin.ui

import android.app.Application

/**
 * Description:
 * Created by zs on 2018/1/17.
 */
class App : Application() {
    companion object {
        private var instance: Application? = null
        fun instance() = instance

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}