package com.example.zs.kotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.zs.kotlin.domain.model.ForecastList

/**
 * Description:天气列表适配器
 * Created by zs on 2017/12/26.
 */
class ForecastListAdapter(val datas: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ForecastListAdapter.ViewHolder {
        return ForecastListAdapter.ViewHolder(TextView(parent!!.context))

    }

    override fun getItemCount(): Int = datas.size()

    override fun onBindViewHolder(holder: ForecastListAdapter.ViewHolder?, position: Int) {
        // Kotlin 扩展函数with是一个非常有用的函数，它包含在Kotlin的标准库中。它接收一个对象和一个扩展函数作为
        // 它的参数，然后使这个对象扩展这个函数。这表示所有我们在括号中编写的代码都是作为对象（第一个参数）
        // 的一个扩展函数，我们可以就像作为this一样使用所有它的public方法和属性。
        // 当我们针对同一个对象做很多操作的时候这个非常有利于简化代码。
        with(datas[position]) {
            holder!!.textView.text = "$date - $description = $high / $low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}




