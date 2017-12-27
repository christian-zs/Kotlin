package com.example.zs.kotlin.data

import com.google.gson.Gson
import java.net.URL

/**
 * Description:请求天气接口
 * Created by zs on 2017/12/26.
 */
class ForecastRequest(private val zipCode: String) {
    companion object {

        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun run(): ForecastResult {
        val result = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(result, ForecastResult::class.java)
    }
}
