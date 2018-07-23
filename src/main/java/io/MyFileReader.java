/**
 *
 */
package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gongxb
 * @date 2018-1-25  �½�
 */
public class MyFileReader {
    public static FileReader fr;

    public void read() throws IOException {
        fr = new FileReader(new File("D://User//Desktop//edit.txt"));
        char[] cbuf = new char[50];
        int tmp;
        while ((tmp = fr.read(cbuf)) != -1) {
            System.out.println("=========");
            System.out.println(new String(cbuf, 0, tmp));
        }
        fr.close();
    }
}
