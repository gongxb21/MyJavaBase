/**
 *
 */
package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author gongxb
 * @date 2018-1-25  �½�
 */
public class MyInputStream {
    private static FileInputStream fis;
    private static BufferedInputStream bis;

    public static void inputStream() throws IOException {
        fis = new FileInputStream(new File("D:\\User\\Desktop\\edit.txt"));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
    }

    public static void bufferInputStream() throws IOException {
        bis = new BufferedInputStream(new FileInputStream(new File("D:\\User\\Desktop\\edit.txt")), 1024);
        int i = bis.available();
        System.out.println("size i=" + i);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            System.out.println("aaaa");
            System.out.println(new String(bytes, 0, len));
        }
        bis.close();
    }
}
