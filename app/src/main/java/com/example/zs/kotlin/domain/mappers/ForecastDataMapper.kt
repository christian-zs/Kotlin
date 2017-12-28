package com.example.zs.kotlin.domain.mappers

import com.example.zs.kotlin.data.Forecast
import com.example.zs.kotlin.data.ForecastResult
import com.example.zs.kotlin.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
// 声明别名
import com.example.zs.kotlin.domain.model.Forecast as ModelForecast

/**
 * Description:
 * Created by zs on 2017/12/27.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    /**
     * 转换时间
     */
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"
}