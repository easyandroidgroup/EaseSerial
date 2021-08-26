package com.farmer.baseserial

import com.farmer.baseserial.module.DataPackageProcess


/**
 * 文 件 名: ReaderDataPackageProcess
 * 创 建 人: farmer
 * 创建日期: 2020/7/28 17:36
 * 修改时间：
 * 修改备注：
 */

class ReaderDataPackageProcess : DataPackageProcess() {

    override fun analyData(messageTran: Any) {
        this.setChanged()
        this.notifyObservers(messageTran)
    }

}