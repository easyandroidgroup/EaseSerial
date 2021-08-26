package com.farmer.baseserial.utils

/**
 * 文 件 名: ByteUtil
 * 创 建 人: farmer
 * 创建日期: 2020/11/25 15:39
 * 修改时间：
 * 修改备注：
 */

object ByteUtil {

    //将字节转换为高低位
    fun getHighLowBytes(int: Int): ByteArray {
        val high = (int shr 8).toByte()
        val low = (int and 0xFF).toByte()
        return byteArrayOf(high, low)
    }
}