package com.example.zs.kotlin.ui.acticity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.zs.kotlin.R
import com.example.zs.kotlin.domain.commands.RequestForecastCommand
import com.example.zs.kotlin.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

/**
 * Description: 列表 (练习函数、类、参数)
 * Created by zs on 2017/12/26.
 */
class ForecastActivity : AppCompatActivity() {
    private var adapter: ForecastListAdapter? = null
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
        val linearLayoutManger = LinearLayoutManager(applicationContext)
        linearLayoutManger.orientation = RecyclerView.VERTICAL
        forecastList.layoutManager = linearLayoutManger

        doAsync {
            val result = RequestForecastCommand("94043").excult()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { forecast ->
                    longToast(forecast.date)
                }
            }
        }
    }
}