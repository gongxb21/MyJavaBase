/**
 *
 */
package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gongxb
 * @date 2018-1-25  �½�
 */
public class MyOutputStream {
    private static FileOutputStream fos;
    private static BufferedOutputStream bos;

    public static void outputStream() throws IOException {
        fos = new FileOutputStream(new File("D:/User/Desktop/aaa.txt"));
        fos.write("asdfjkl;qwerityoiuoewnncxzjlkd;sa".getBytes());
        fos.close();
    }

    public static void bufferedOutputStream() throws IOException {
        bos = new BufferedOutputStream(new FileOutputStream(new File("d:" + File.separator + "gaga.txt")));
        bos.write("asdfsdfsafsfsdafsafsadfsafsafsafdsaf".getBytes());
        bos.flush();
        bos.close();
    }
}
