package cn.farmer.qrcode.observer

import cn.farmer.qrcode.bean.QrCodeResult
import java.util.*

/**
 * @packageName: SerialPortDemo
 * @fileName: QrCodeResultObserver
 * @author: farmer
 * @date: 2021-03-03 14:28
 * @description: 扫码结果回调
 */
interface QrCodeResultObserver : Observer {

    override fun update(o: Observable?, arg: Any?) {
        arg?.let {
            if (it is QrCodeResult) {
                result(it)
            }
        }
    }

    //驱动结果
    fun result(qrCodeResult: QrCodeResult)
}