package com.example.zs.kotlin.domain.model

/**
 * Description: 实体类
 * Created by zs on 2017/12/27.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)