package com.farmer.baseserial.controller

import android.os.Handler
import com.farmer.baseserial.module.DataPackageParser
import com.farmer.baseserial.module.DataPackageProcess
import farmerserial.ComBean
import farmerserial.SerialHelper

/**
 * 文 件 名: SerialController
 * 创 建 人: farmer
 * 创建日期: 2020/7/28 17:47
 * 修改时间：
 * 修改备注：
 */

class SerialController(
    private val dataPackageParse: DataPackageParser,
    private val dataPackageProcess: DataPackageProcess,
    sPort: String = "/dev/ttyS3",
    sBaudRate: String = "9600"
) : SerialHelper(sPort, sBaudRate) {

    private val handler = Handler()


    override fun onDataReceived(comRecData: ComBean?) {
        //只要收到消息就取消未收到计时
        handler.removeCallbacksAndMessages(null)
        comRecData?.let {
            dataPackageParse.runReceiveDataCallback(comRecData.bRec, dataPackageProcess)
        }
    }


    override fun send(bOutArray: ByteArray?) {
        super.send(bOutArray)
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed(
            { dataPackageParse.runReceiveDataCallback(null, dataPackageProcess) },
            2000
        )
    }

}