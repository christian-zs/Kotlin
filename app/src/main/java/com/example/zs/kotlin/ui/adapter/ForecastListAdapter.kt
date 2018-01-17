package com.example.zs.kotlin.ui.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zs.kotlin.R
import com.example.zs.kotlin.domain.model.Forecast
import com.example.zs.kotlin.domain.model.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_forecast.view.*

/**
 * Description:天气列表适配器
 * Created by zs on 2017/12/26.
 */
class ForecastListAdapter(
        private val forecastList: ForecastList,
        private val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {


    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_forecast, parent, false)
        return ForecastListAdapter.ViewHolder(view, itemClick)

    }

    override fun getItemCount(): Int = forecastList.size()

    override fun onBindViewHolder(holder: ForecastListAdapter.ViewHolder?, position: Int) {
        holder!!.bindForecast(forecastList[position])

    }

    class ViewHolder(
            private val itemLayout: View,
            private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(itemLayout) {

        fun bindForecast(forecast: Forecast) {
            // Kotlin 扩展函数with是一个非常有用的函数，它包含在Kotlin的标准库中。它接收一个对象和一个扩展函数作为
            // 它的参数，然后使这个对象扩展这个函数。这表示所有我们在括号中编写的代码都是作为对象（第一个参数）
            // 的一个扩展函数，我们可以就像作为this一样使用所有它的public方法和属性。
            // 当我们针对同一个对象做很多操作的时候这个非常有利于简化代码。
            with(forecast) {
                Picasso.with(itemLayout.context).load(forecast.iconUrl).into(itemLayout.icon)
                itemLayout.date.text = forecast.date
                itemLayout.description.text = forecast.description
                itemLayout.maxTemperature.text = "${forecast.high}"
                itemLayout.minTemperature.text = "$low"
                itemLayout.setOnClickListener { itemClick(this) }
            }
        }
    }
}




