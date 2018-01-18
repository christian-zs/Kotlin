package com.example.zs.kotlin.domain.commands

/**
 * Description: 执行接口
 * Created by zs on 2017/12/27.
 */
interface Command<out T> {
    fun excult(): T
}
