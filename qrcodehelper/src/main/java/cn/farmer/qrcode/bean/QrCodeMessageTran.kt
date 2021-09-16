package cn.farmer.qrcode.bean

import serialport_idic.MyFunc

/**
 * @packageName: SerialPortDemo
 * @fileName: QrCodeMessageTran
 * @author: farmer
 * @date: 2021-03-03 14:28
 * @description: 扫码数据
 */
open class QrCodeMessageTran constructor(
    //数据
    val byteArray: ByteArray?
) {
    //提示信息
    var qrCodeString: String? = null
    override fun toString(): String {
        return "MessageTran(byteArray=${byteArray?.let { MyFunc.ByteArrToHex(it) }}，qrCodeString=$qrCodeString)"
    }
}


