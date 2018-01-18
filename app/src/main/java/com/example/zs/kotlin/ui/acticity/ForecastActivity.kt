package com.example.zs.kotlin.ui.acticity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
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
        val sort: IntArray = intArrayOf(30, 5, 42, 41, 33, 1, 56)
        quickSort(sort, 0, sort.size - 1)
    }

    //快速排序
    private fun quickSort(a: IntArray, left: Int, right: Int) {
        if (left < right) {
            var i: Int
            var j: Int
            var t: Int
            val temp: Int
            temp = a[left] //temp中存的就是基准数
            i = left
            j = right
            while (i != j) {
                //顺序很重要，要先从右边开始找
                while (a[j] >= temp && i < j) {
                    j--
                    Log.d("右边", a.contentToString())
                    Log.d(" j", j.toString())
                }
                //再找左边的
                while (a[i] <= temp && i < j) {
                    i++
                    Log.d("左边", a.contentToString())
                    Log.d(" i", i.toString())
                }

                //交换两个数在数组中的位置
                if (i < j) {
                    Log.d("交换 i j", i.toString() + "---" + j.toString())
                    t = a[i]
                    a[i] = a[j]
                    a[j] = t
                    Log.d("交换", a.contentToString())
                }
            }
            //最终将基准数归位
            a[left] = a[i]
            a[i] = temp
            Log.d("确定基数", a.contentToString())
//            quickSort(a, left, i - 1)//继续处理左边的，这里是一个递归的过程
//
//            Log.d("处理右边",  a.contentToString())
//            quickSort(a, i + 1, right)//继续处理右边的 ，这里是一个递归的过程
//
//            Log.d("处理左边", a.contentToString())
        }
    }
}