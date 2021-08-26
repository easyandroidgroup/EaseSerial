package cn.farmer.qrcode

import cn.farmer.qrcode.bean.QrCodeMessageTran
import com.farmer.baseserial.module.DataPackageParser
import com.farmer.baseserial.module.DataPackageProcess

/**
 * @packageName: SerialPortDemo
 * @fileName: ReaderQrCodePackageParse
 * @author: farmer
 * @date: 2021-03-03 14:35
 * @description:
 */
class ReaderQrCodePackageParse : DataPackageParser {
    override fun runReceiveDataCallback(
        byteArray: ByteArray?,
        dataPackageProcess: DataPackageProcess
    ) {
        val messageTran = QrCodeMessageTran(byteArray)
        if (byteArray != null) {
            messageTran.qrCodeString = String(byteArray, Charsets.UTF_8)
        }
        dataPackageProcess.analyData(messageTran)
    }
}