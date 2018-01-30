package com.example.zs.kotlin.domain.commands

import com.example.zs.kotlin.data.ForecastRequest
import com.example.zs.kotlin.domain.mappers.ForecastDataMapper
import com.example.zs.kotlin.domain.model.ForecastList


/**
 * Description:执行
 * Created by zs on 2017/12/27.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun excult(): ForecastList {
        return ForecastDataMapper().convertFromDataModel(
                ForecastRequest(zipCode).run())
    }

}