package com.farmer.baseserial.module

import java.util.*

/**
 * 文 件 名: DataPackageProcess
 * 创 建 人: farmer
 * 创建日期: 2020/7/28 17:35
 * 修改时间：
 * 修改备注：
 */

abstract class DataPackageProcess : Observable() {

    abstract fun analyData(messageTran: Any)
}