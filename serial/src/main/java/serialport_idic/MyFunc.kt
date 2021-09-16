package serialport_idic

import java.util.*

/**
 * @author benjaminwan
 * ����ת������
 */
object MyFunc {
    //-------------------------------------------------------
    // �ж�������ż����λ���㣬���һλ��1��Ϊ������Ϊ0��ż��
    fun isOdd(num: Int): Int {
        return num and 0x1
    }

    //16进制转10进制
    fun HexToInt1(strHex: String): Int {
        var nResult = 0
        if (!IsHex(strHex)) return nResult
        var str = strHex.toUpperCase(Locale.ROOT)
        if (str.length > 2) {
            if (str[0] == '0' && str[1] == 'X') {
                str = str.substring(2)
            }
        }
        val nLen = str.length
        for (i in 0 until nLen) {
            val ch = str[nLen - i - 1]
            try {
                nResult += GetHex(ch) * GetPower(16, i)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return nResult
    }

    //计算16进制对应的数值
    @Throws(Exception::class)
    fun GetHex(ch: Char): Int {
        if (ch in '0'..'9') return (ch - '0')
        if (ch in 'a'..'f') return (ch - 'a' + 10)
        if (ch in 'A'..'F') return (ch - 'A' + 10)
        throw Exception("error param")
    }

    //计算幂
    @Throws(Exception::class)
    fun GetPower(nValue: Int, nCount: Int): Int {
        if (nCount < 0) throw Exception("nCount can't small than 1!")
        if (nCount == 0) return 1
        var nSum = 1
        for (i in 0 until nCount) {
            nSum = nSum * nValue
        }
        return nSum
    }

    //判断是否是16进制数
    fun IsHex(strHex: String): Boolean {
        var i = 0
        if (strHex.length > 2) {
            if (strHex[0] == '0' && (strHex[1] == 'X' || strHex[1] == 'x')) {
                i = 2
            }
        }
        while (i < strHex.length) {
            val ch = strHex[i]
            if (ch in '0'..'9' || ch in 'A'..'F' || ch in 'a'..'f') {
                ++i
                continue
            }
            return false
            ++i
        }
        return true
    }

    //-------------------------------------------------------
    fun HexToByte(inHex: String): Byte //Hex�ַ���תbyte
    {
        return inHex.toInt(16).toByte()
    }

    //-------------------------------------------------------
    fun Byte2Hex(inByte: Byte?): String //1�ֽ�ת2��Hex�ַ�
    {
        return String.format("%02x", inByte).toUpperCase(Locale.ROOT)
    }

    //-------------------------------------------------------
    fun ByteArrToHex(inBytArr: ByteArray): String //�ֽ�����תתhex�ַ���
    {
        val strBuilder = StringBuilder()
        val j = inBytArr.size
        for (i in 0 until j) {
            strBuilder.append(Byte2Hex(inBytArr[i]))
        }
        return strBuilder.toString()
    }

    //-------------------------------------------------------
    fun ByteArrToHex(
        inBytArr: ByteArray, offset: Int,
        byteCount: Int
    ): String //�ֽ�����תתhex�ַ�������ѡ����
    {
        val strBuilder = StringBuilder()
        for (i in offset until byteCount) {
            strBuilder.append(Byte2Hex(inBytArr[i]))
        }
        return strBuilder.toString()
    }

    //-------------------------------------------------------
    //תhex�ַ���ת�ֽ�����
    @JvmStatic
    fun HexToByteArr(inHex: String): ByteArray //hex�ַ���ת�ֽ�����
    {
        var inHex = inHex
        var hexlen = inHex.length
        val result: ByteArray
        if (isOdd(hexlen) == 1) { //����
            hexlen++
            result = ByteArray(hexlen / 2)
            inHex = "0$inHex"
        } else { //ż��
            result = ByteArray(hexlen / 2)
        }
        var j = 0
        var i = 0
        while (i < hexlen) {
            result[j] = HexToByte(inHex.substring(i, i + 2))
            j++
            i += 2
        }
        return result
    }

    /**
     * 将byte[]数组转化为String类型
     *
     * @param arg 需要转换的byte[]数组
     * @return 转换后的String队形
     */
    fun toHexString(arg: ByteArray): String {
        val result = StringBuilder()
        for (anArg in arg) {
            val hexString =
                Integer.toHexString(if (anArg < 0) anArg + 256 else anArg.toInt())
            result.append(if (hexString.length == 1) "0$hexString" else hexString).append(" ")
        }
        return result.toString()
    }

    fun byte2Int(byte: Byte): Int {
        return HexToInt1(Byte2Hex(byte))
    }
}