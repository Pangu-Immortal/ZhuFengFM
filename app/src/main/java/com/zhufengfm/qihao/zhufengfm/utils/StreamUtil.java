package com.zhufengfm.qihao.zhufengfm.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;

/**
 * IO 操作的工具类
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 将输入流中的数据，读出来存储在字节数组中
     *
     * @param in
     * @return
     */
    public static byte[] readStream(InputStream in) throws IOException {
        byte[] ret = null;

        if (in != null) {
            byte[] buf = new byte[128];
            int len = 0;
            ByteArrayOutputStream bout = null;
            bout = new ByteArrayOutputStream();

            while ((len = in.read(buf)) != -1) {
                bout.write(buf, 0, len);
            }
            buf = null;
            ret = bout.toByteArray();
            bout.close();
        }

        return ret;
    }


}
