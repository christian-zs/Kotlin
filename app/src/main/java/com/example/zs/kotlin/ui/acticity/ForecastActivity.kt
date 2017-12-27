package com.example.zs.kotlin.ui.acticity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.zs.kotlin.R
import com.example.zs.kotlin.data.ForecastRequest
import com.example.zs.kotlin.ui.adapter.WeatherListAdapter
import org.jetbrains.anko.asyncResult
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

/**
 * Description: 列表 (练习函数、类、参数)
 * Created by zs on 2017/12/26.
 */
class ForecastActivity : AppCompatActivity() {
    private var adapter: WeatherListAdapter? = null
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        // 使用 AnKo 扩展函数
        val recycler: RecyclerView = find(R.id.recycler_list)
        val linearLayoutManger = LinearLayoutManager(applicationContext)
        linearLayoutManger.orientation = RecyclerView.VERTICAL
        recycler.layoutManager = linearLayoutManger
        adapter = WeatherListAdapter(items)
        recycler.adapter = adapter

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"
        asyncResult {
            ForecastRequest(url).run()
            uiThread { longToast("ForecastRequest performed") }
        }
    }
}