package com.android.zhufeng.fm.util;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */

import java.io.*;
import java.net.HttpURLConnection;

/**
 * IO操作的工具类
 */
public final class StreamUtil {
    private StreamUtil() {

    }

    public static void close(Object stream) {
        if (stream != null) {

            try {
                if (stream instanceof InputStream) {
                    ((InputStream) stream).close();
                } else if (stream instanceof OutputStream) {
                    ((OutputStream) stream).close();
                } else if (stream instanceof Reader) {
                    ((Reader) stream).close();
                } else if (stream instanceof Writer) {
                    ((Writer) stream).close();
                } else if (stream instanceof HttpURLConnection) {
                    ((HttpURLConnection) stream).disconnect();
                }
            } catch (Exception ex) {

            }

        }
    }

    /**
     * 将输入流中的数据，读出来存储在自己数组中
     *
     * @param in
     * @return
     */
    public static byte[] readStream(InputStream in) throws IOException {
        byte[] ret = null;
        if (in != null) {
            byte[] buf = new byte[128];
            int len;

            ByteArrayOutputStream bout = null;

            bout = new ByteArrayOutputStream();

            while (true) {
                len = in.read(buf);
                if (len == -1) {
                    break;
                }
                bout.write(buf, 0, len);
            }

            buf = null;
            ret = bout.toByteArray();
            bout.close();
        }
        return ret;
    }

}
