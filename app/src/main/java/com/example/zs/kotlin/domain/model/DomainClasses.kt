package com.example.zs.kotlin.domain.model

/**
 * Description: 实体类 Adapter 中展现给用户显示的类
 * Created by zs on 2017/12/27.
 */
data class ForecastList(
        val city: String,
        val country: String,
        private val dailyForecast: List<Forecast>) {
    fun size() = dailyForecast.size
    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(
        val date: String,
        val description: String,
        val high: Int,
        val low: Int,
        val iconUrl: String)