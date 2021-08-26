package com.farmer.serialport

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * @packageName: SerialPortDemo
 * @fileName: LogAdapter
 * @author: farmer
 * @date: 2021-08-26 10:27
 * @description:
 */
@SuppressLint("SimpleDateFormat")
class LogAdapter(private var context: Context?) : BaseAdapter() {
    val format = SimpleDateFormat("[yyyy-MM-dd HH:mm:ss:SSS]：")
    private val logs = ArrayList<String>()

    override fun getCount(): Int {
        return if (logs.isNullOrEmpty()) {
            0
        } else {
            logs.size
        }
    }

    fun addText(text: String) {
        logs.add(0, format.format(Date()) + text)
        notifyDataSetChanged()
        if (logs.size > 100) {
            logs.subList(100, logs.size).clear()
        }
    }

    override fun getItem(position: Int): Any {
        return logs[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            val textView = TextView(context)
            textView.setTextColor(Color.BLACK)
            view = textView
        }
        val text = view as TextView
        text.text = getItem(position).toString()
        return text
    }
}