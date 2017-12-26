package com.example.zs.kotlin.data

import java.net.URL

/**
 * Description:请求天气接口
 * Created by zs on 2017/12/26.
 */
class Request(private val url: String) {
    fun run() {
        val result = URL(url).readText()
        print(result)
    }
}
