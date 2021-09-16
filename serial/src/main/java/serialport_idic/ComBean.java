
package serialport_idic;

import java.text.SimpleDateFormat;

public class ComBean {
    public byte[] bRec = null;
    public String sRecTime = "";
    public String sComPort = "";

    public ComBean(String sPort, byte[] buffer, int size) {
        sComPort = sPort;
        bRec = new byte[size];
        System.arraycopy(buffer, 0, bRec, 0, size);
        SimpleDateFormat sDateFormat = new SimpleDateFormat("hh:mm:ss");
        sRecTime = sDateFormat.format(new java.util.Date());
    }
}


