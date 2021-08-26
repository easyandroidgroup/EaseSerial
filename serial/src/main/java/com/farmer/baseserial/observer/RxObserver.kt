package com.farmer.baseserial.observer

import android.util.Log
import java.util.*

/**
 * 文 件 名: RxObserver
 * 创 建 人: farmer
 * 创建日期: 2020/8/20 09:28
 * 修改时间：
 * 修改备注：
 */

abstract class RxObserver : Observer {

    val TAG = "RxObserver"

    override fun update(o: Observable?, arg: Any?) {
        arg?.let {
            Log.d(TAG, "$it")
            analyData(it)
        }
    }

    abstract fun analyData(messageTran: Any)


}