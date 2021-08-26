package com.farmer.baseserial.utils

import android.util.Log

/**
 * 文 件 名: CRC16Util
 * 创 建 人: farmer
 * 创建日期: 2020/11/25 17:51
 * 修改时间：
 * 修改备注：
 */

object CRC16Util {
    var crc16_tab_h = byteArrayOf(
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x00.toByte(),
        0xC1.toByte(),
        0x81.toByte(),
        0x40.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(),
        0x01.toByte(),
        0xC0.toByte(),
        0x80.toByte(),
        0x41.toByte(), 0x00.toByte(), 0xC1.toByte(), 0x81.toByte(), 0x40.toByte()
    )
    var crc16_tab_l = byteArrayOf(
        0x00.toByte(),
        0xC0.toByte(),
        0xC1.toByte(),
        0x01.toByte(),
        0xC3.toByte(),
        0x03.toByte(),
        0x02.toByte(),
        0xC2.toByte(),
        0xC6.toByte(),
        0x06.toByte(),
        0x07.toByte(),
        0xC7.toByte(),
        0x05.toByte(),
        0xC5.toByte(),
        0xC4.toByte(),
        0x04.toByte(),
        0xCC.toByte(),
        0x0C.toByte(),
        0x0D.toByte(),
        0xCD.toByte(),
        0x0F.toByte(),
        0xCF.toByte(),
        0xCE.toByte(),
        0x0E.toByte(),
        0x0A.toByte(),
        0xCA.toByte(),
        0xCB.toByte(),
        0x0B.toByte(),
        0xC9.toByte(),
        0x09.toByte(),
        0x08.toByte(),
        0xC8.toByte(),
        0xD8.toByte(),
        0x18.toByte(),
        0x19.toByte(),
        0xD9.toByte(),
        0x1B.toByte(),
        0xDB.toByte(),
        0xDA.toByte(),
        0x1A.toByte(),
        0x1E.toByte(),
        0xDE.toByte(),
        0xDF.toByte(),
        0x1F.toByte(),
        0xDD.toByte(),
        0x1D.toByte(),
        0x1C.toByte(),
        0xDC.toByte(),
        0x14.toByte(),
        0xD4.toByte(),
        0xD5.toByte(),
        0x15.toByte(),
        0xD7.toByte(),
        0x17.toByte(),
        0x16.toByte(),
        0xD6.toByte(),
        0xD2.toByte(),
        0x12.toByte(),
        0x13.toByte(),
        0xD3.toByte(),
        0x11.toByte(),
        0xD1.toByte(),
        0xD0.toByte(),
        0x10.toByte(),
        0xF0.toByte(),
        0x30.toByte(),
        0x31.toByte(),
        0xF1.toByte(),
        0x33.toByte(),
        0xF3.toByte(),
        0xF2.toByte(),
        0x32.toByte(),
        0x36.toByte(),
        0xF6.toByte(),
        0xF7.toByte(),
        0x37.toByte(),
        0xF5.toByte(),
        0x35.toByte(),
        0x34.toByte(),
        0xF4.toByte(),
        0x3C.toByte(),
        0xFC.toByte(),
        0xFD.toByte(),
        0x3D.toByte(),
        0xFF.toByte(),
        0x3F.toByte(),
        0x3E.toByte(),
        0xFE.toByte(),
        0xFA.toByte(),
        0x3A.toByte(),
        0x3B.toByte(),
        0xFB.toByte(),
        0x39.toByte(),
        0xF9.toByte(),
        0xF8.toByte(),
        0x38.toByte(),
        0x28.toByte(),
        0xE8.toByte(),
        0xE9.toByte(),
        0x29.toByte(),
        0xEB.toByte(),
        0x2B.toByte(),
        0x2A.toByte(),
        0xEA.toByte(),
        0xEE.toByte(),
        0x2E.toByte(),
        0x2F.toByte(),
        0xEF.toByte(),
        0x2D.toByte(),
        0xED.toByte(),
        0xEC.toByte(),
        0x2C.toByte(),
        0xE4.toByte(),
        0x24.toByte(),
        0x25.toByte(),
        0xE5.toByte(),
        0x27.toByte(),
        0xE7.toByte(),
        0xE6.toByte(),
        0x26.toByte(),
        0x22.toByte(),
        0xE2.toByte(),
        0xE3.toByte(),
        0x23.toByte(),
        0xE1.toByte(),
        0x21.toByte(),
        0x20.toByte(),
        0xE0.toByte(),
        0xA0.toByte(),
        0x60.toByte(),
        0x61.toByte(),
        0xA1.toByte(),
        0x63.toByte(),
        0xA3.toByte(),
        0xA2.toByte(),
        0x62.toByte(),
        0x66.toByte(),
        0xA6.toByte(),
        0xA7.toByte(),
        0x67.toByte(),
        0xA5.toByte(),
        0x65.toByte(),
        0x64.toByte(),
        0xA4.toByte(),
        0x6C.toByte(),
        0xAC.toByte(),
        0xAD.toByte(),
        0x6D.toByte(),
        0xAF.toByte(),
        0x6F.toByte(),
        0x6E.toByte(),
        0xAE.toByte(),
        0xAA.toByte(),
        0x6A.toByte(),
        0x6B.toByte(),
        0xAB.toByte(),
        0x69.toByte(),
        0xA9.toByte(),
        0xA8.toByte(),
        0x68.toByte(),
        0x78.toByte(),
        0xB8.toByte(),
        0xB9.toByte(),
        0x79.toByte(),
        0xBB.toByte(),
        0x7B.toByte(),
        0x7A.toByte(),
        0xBA.toByte(),
        0xBE.toByte(),
        0x7E.toByte(),
        0x7F.toByte(),
        0xBF.toByte(),
        0x7D.toByte(),
        0xBD.toByte(),
        0xBC.toByte(),
        0x7C.toByte(),
        0xB4.toByte(),
        0x74.toByte(),
        0x75.toByte(),
        0xB5.toByte(),
        0x77.toByte(),
        0xB7.toByte(),
        0xB6.toByte(),
        0x76.toByte(),
        0x72.toByte(),
        0xB2.toByte(),
        0xB3.toByte(),
        0x73.toByte(),
        0xB1.toByte(),
        0x71.toByte(),
        0x70.toByte(),
        0xB0.toByte(),
        0x50.toByte(),
        0x90.toByte(),
        0x91.toByte(),
        0x51.toByte(),
        0x93.toByte(),
        0x53.toByte(),
        0x52.toByte(),
        0x92.toByte(),
        0x96.toByte(),
        0x56.toByte(),
        0x57.toByte(),
        0x97.toByte(),
        0x55.toByte(),
        0x95.toByte(),
        0x94.toByte(),
        0x54.toByte(),
        0x9C.toByte(),
        0x5C.toByte(),
        0x5D.toByte(),
        0x9D.toByte(),
        0x5F.toByte(),
        0x9F.toByte(),
        0x9E.toByte(),
        0x5E.toByte(),
        0x5A.toByte(),
        0x9A.toByte(),
        0x9B.toByte(),
        0x5B.toByte(),
        0x99.toByte(),
        0x59.toByte(),
        0x58.toByte(),
        0x98.toByte(),
        0x88.toByte(),
        0x48.toByte(),
        0x49.toByte(),
        0x89.toByte(),
        0x4B.toByte(),
        0x8B.toByte(),
        0x8A.toByte(),
        0x4A.toByte(),
        0x4E.toByte(),
        0x8E.toByte(),
        0x8F.toByte(),
        0x4F.toByte(),
        0x8D.toByte(),
        0x4D.toByte(),
        0x4C.toByte(),
        0x8C.toByte(),
        0x44.toByte(),
        0x84.toByte(),
        0x85.toByte(),
        0x45.toByte(),
        0x87.toByte(),
        0x47.toByte(),
        0x46.toByte(),
        0x86.toByte(),
        0x82.toByte(),
        0x42.toByte(),
        0x43.toByte(),
        0x83.toByte(), 0x41.toByte(), 0x81.toByte(), 0x80.toByte(), 0x40.toByte()
    )
    /**
     * 计算CRC16校验
     *
     * @param data   需要计算的数组
     * @param offset 起始位置
     * @param len    长度
     * @param preval 之前的校验值
     * @return CRC16校验值
     */
    /**
     * 计算CRC16校验
     *
     * @param data   需要计算的数组
     * @param offset 起始位置
     * @param len    长度
     * @return CRC16校验值
     */
    /**
     * 计算CRC16校验  对外的接口
     *
     * @param data 需要计算的数组
     * @return CRC16校验值
     */
    @JvmOverloads
    fun calcCrc16(
        data: ByteArray,
        offset: Int = 0,
        len: Int = data.size,
        preval: Int = 0xffff
    ): Int {
        var ucCRCHi = preval and 0xff00 shr 8
        var ucCRCLo = preval and 0x00ff
        var iIndex: Int
        for (i in 0 until len) {
            iIndex = ucCRCLo xor data[offset + i].toInt() and 0x00ff
            ucCRCLo = ucCRCHi xor crc16_tab_h[iIndex].toInt()
            ucCRCHi = crc16_tab_l[iIndex].toInt()
        }
        return ucCRCHi and 0x00ff shl 8 or (ucCRCLo and 0x00ff) and 0xffff
    }


    fun crcHighLow(byteArray: ByteArray): ByteArray {
        var calcCrc16 = calcCrc16(byteArray)
        val result = String.format("%04x", calcCrc16)
        return byteArrayOf(
            Integer.parseInt(result.substring(2, 4), 16).toByte(),
            Integer.parseInt(result.substring(0, 2), 16).toByte()
        )
    }

    /**
     * 将计算的CRC值 转换为加空格的  比如  ： crc值为 A30A -> A3 0A
     * @param res
     * @return
     */
    fun getCrc(res: Int): String {
        val format = String.format("%04x", res)
        val substring = format.substring(0, 2)
        val substring1 = format.substring(2, 4)
        Log.i("BLUEDATA", "crc ---- : $substring  $substring1")
        return "$substring $substring1 "
    }
}
