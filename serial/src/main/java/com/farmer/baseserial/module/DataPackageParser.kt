package com.farmer.baseserial.module


/**
 * 文 件 名: DataPackageParser
 * 创 建 人: farmer
 * 创建日期: 2020/7/28 17:50
 * 修改时间：
 * 修改备注：
 */

interface DataPackageParser {
    fun runReceiveDataCallback(byteArray: ByteArray?, dataPackageProcess: DataPackageProcess)
}