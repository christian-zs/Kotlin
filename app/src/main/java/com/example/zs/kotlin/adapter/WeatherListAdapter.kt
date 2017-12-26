package com.example.zs.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Description:天气列表适配器
 * Created by zs on 2017/12/26.
 */
class WeatherListAdapter(val datas: List<String>) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherListAdapter.ViewHolder {
        return WeatherListAdapter.ViewHolder(TextView(parent!!.context))

    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: WeatherListAdapter.ViewHolder?, position: Int) {
        holder!!.textView.text = datas[position]
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}




