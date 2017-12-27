package com.example.zs.kotlin.data

import com.google.gson.annotations.SerializedName

/**
 * Description: 数据解析类 天气返回 json 解析实体
 * Created by zs on 2017/12/27.
 */


data class ForecastResult(
        val city: City,
        val list: List<Forecast>)

data class City(
        // Gson 解析字段
        @SerializedName("id")
        val id: Long,
        val name: String,
        val coord: Coordinates,
        val country: String,
        val population: Int)

data class Coordinates(
        val lon: Float,
        val lat: Float)

data class Forecast(
        val dt: Long,
        val temp: Temperature,
        val pressure: Float,
        val humidity: Int,
        val weather: List<Weather>,
        val speed: Float,
        val deg: Int,
        val clouds: Int,
        val rain: Float)

data class Temperature(
        val day: Float,
        val min: Float,
        val max: Float,
        val night: Float,
        val eve: Float,
        val morn: Float)

data class Weather(
        val id: Long,
        val main: String,
        val description: String,
        val icon: String)
