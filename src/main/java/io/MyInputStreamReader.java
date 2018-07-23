/**
 *
 */
package io;

import java.io.*;
import java.net.MalformedURLException;

/**
 * @author gongxb
 * @date 2018-1-25  �½�
 */
public class MyInputStreamReader {
    private static InputStreamReader isr;

    public void read() throws MalformedURLException, IOException {
        InputStream in = new FileInputStream(new File("D:\\User\\Desktop\\editutf8.txt"));
        isr = new InputStreamReader(in, "UTF-8");
        int tmp;
        while ((tmp = isr.read()) != -1) {
            System.out.println((char) tmp);
        }
        isr.close();
    }
}
