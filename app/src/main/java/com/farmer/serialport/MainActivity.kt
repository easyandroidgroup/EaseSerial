package com.farmer.serialport

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import cn.farmer.qrcode.QrCodeRunHelper
import cn.farmer.qrcode.bean.QrCodeResult
import cn.farmer.qrcode.observer.QrCodeResultObserver
import com.elvishew.xlog.XLog
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity(), QrCodeResultObserver {

    private val helper by lazy { QrCodeRunHelper.defaultHelper }

    private lateinit var listAdapter: LogAdapter
    private var isOpen = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        XLog.init()
        listAdapter = LogAdapter(this)
        listView.adapter = listAdapter
        connect?.setOnClickListener {
            val port = dev.text.toString().trim()
            val baudrate = baudrate.text.toString().trim()
            val serialFile: File = File(port)
            if (isOpen) {
                helper.close()
                dhstatus?.text = "串口：${port}关闭成功"
                connect?.text = "打开串口"
                showResult("串口：${port}关闭成功")
                isOpen = false
            } else {
                if (TextUtils.isEmpty(port) || TextUtils.isEmpty(baudrate)) {
                    showResult("请输入串口及连接波特率")
                    return@setOnClickListener
                }
                if (!port.startsWith("/dev")) {
                    showResult("串口格式不正确，请检查后再打开")
                    return@setOnClickListener
                }
                if (!serialFile.exists() || baudrate.toInt() == -1) {
                    showResult("串口不存在或连接波特率错误")
                    return@setOnClickListener
                }
                isOpen = helper.connect(port, baudrate)
                dhstatus?.text = if (isOpen) "串口：${port}连接成功" else "串口：${port}连接失败"
                showResult("打开串口是否成功：${isOpen}，串口：${port}，波特率：${baudrate}")
                connect?.text = if (isOpen) "关闭串口" else "打开串口"
                if (isOpen) {
                    showResult("打开串口成功：请插上刷卡器刷卡或者扫码器扫码")
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        helper.qrCodeResultObserver = this
    }

    override fun update(o: Observable?, arg: Any?) {

    }

    override fun result(qrCodeResult: QrCodeResult) {
        val success = qrCodeResult.success
        val qrCodeString = qrCodeResult.qrCodeString
        val cardCmd = qrCodeResult.cardCmd
        showResult("指令操作是否成功success：${success}，刷卡/扫码读取到的数值：${qrCodeString}，读取到的指令信息：${cardCmd}")
    }

    @SuppressLint("SetTextI18n")
    private fun showResult(result: String) {
        if (TextUtils.isEmpty(result)) {
            return
        }
        addText(result)
    }

    /**
     * 添加数据
     */
    private fun addText(text: String) {
        listView.post(object : RunableEx(text) {
            override fun run() {
                listAdapter.addText(text)
            }
        })
    }

    override fun onStop() {
        super.onStop()
        isOpen = false
        helper.qrCodeResultObserver = null
    }
}