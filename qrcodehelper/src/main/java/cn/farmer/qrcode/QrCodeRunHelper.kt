package cn.farmer.qrcode

import android.util.Log
import cn.farmer.qrcode.bean.QrCodeMessageTran
import cn.farmer.qrcode.bean.QrCodeResult
import cn.farmer.qrcode.observer.QrCodeResultObserver
import com.farmer.baseserial.ConnectHelper
import serialport_idic.MyFunc

/**
 * @packageName: SerialPortDemo
 * @fileName: QrCodeRunHelper
 * @author: farmer
 * @date: 2021-03-03 14:39
 * @description:
 */
class QrCodeRunHelper : ConnectHelper(ReaderQrCodePackageParse()) {
    var qrCodeResultObserver: QrCodeResultObserver? = null

    companion object {
        const val TAG = "QrCode"
        val defaultHelper = QrCodeRunHelper()
    }

    override fun analyData(messageTran: Any) {
        if (messageTran is QrCodeMessageTran) {
            val qrCodeResult = QrCodeResult().apply {
                this.success = (messageTran.byteArray != null)
                this.qrCodeString = messageTran.qrCodeString ?: ""
                this.cardCmd =
                    if (messageTran.byteArray != null) MyFunc.ByteArrToHex(messageTran.byteArray) else "读取指令失败"

            }
            Log.e(TAG, "返回的信息:${qrCodeResult.qrCodeString}")
            qrCodeResultObserver?.result(qrCodeResult)
        }
    }
}