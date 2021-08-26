package cn.farmer.qrcode.bean

import farmerserial.MyFunc
import kotlin.properties.Delegates

/**
 * @packageName: SerialPortDemo
 * @fileName: QrCodeResult
 * @author: farmer
 * @date: 2021-03-03 14:28
 * @description: 扫码结果
 */
open class QrCodeResult {
    //是否成功
    var success by Delegates.notNull<Boolean>()

    //结果信息
    var qrCodeString by Delegates.notNull<String>()

    //解析指令
    var cardCmd by Delegates.notNull<String>()

    override fun toString(): String {
        return "DriverResult(success=${success}, qrCodeString=$qrCodeString,cardCmd=$cardCmd)"
    }
}