package com.farmer.baseserial

import android.util.Log
import com.farmer.baseserial.controller.SerialController
import com.farmer.baseserial.module.DataPackageParser
import com.farmer.baseserial.observer.RxObserver
import serialport_idic.MyFunc

/**
 * 文 件 名: ConnectHelper
 * 创 建 人: farmer
 * 创建日期: 2020/9/14 10:55
 * 修改时间：
 * 修改备注：
 */

abstract class ConnectHelper(
    private val packageParser: DataPackageParser
) : RxObserver() {

    private val packageProcess = ReaderDataPackageProcess()

    private lateinit var serialHelper: SerialController

    /**
     * 打开串口
     * [sPort] 串口名称
     * [sBaudRate] 波特率
     */
    fun connect(
        sPort: String = "/dev/ttyS3",
        sBaudRate: String = "9600"
    ): Boolean {
        Log.d(TAG, "打开$sPort 串口,波特率为$sBaudRate")
        serialHelper = SerialController(packageParser, packageProcess, sPort, sBaudRate)
        packageProcess.addObserver(this)
        serialHelper.open()
        return serialHelper.isOpen
    }

    fun close() {
        serialHelper.close()
    }

    fun send(bOutArray: ByteArray) {
        Log.d("send", MyFunc.ByteArrToHex(bOutArray))
        serialHelper.send(bOutArray)
    }
}