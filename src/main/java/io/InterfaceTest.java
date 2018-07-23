/**
 *
 */
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gongxb
 * @date 2018-1-25  �½�
 */
public class InterfaceTest {
    /**
     * ����һ�������У�ĳ���ֶγ��ֵĴ���
     * int
     *
     * @return
     * @throws IOException
     */
    public int getStringCount() throws IOException {
        int i = 0;
        String str = read();
        System.out.println("the String is " + str);
        String key = "Ҫ";
        i = count(str, key);
        return i;
    }

    public static int count(String text, String sub) {
        int count = 0, start = 0;
        while ((start = text.indexOf(sub, start)) >= 0) {
            start += sub.length();
            count++;
        }
        return count;
    }

    /**
     * ��ȡ�ı��������ַ���
     * String
     *
     * @return
     * @throws IOException
     */
    public String read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("D://User//Desktop//edit2.txt")));
        StringBuilder builder = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            builder.append(str);
        }
        br.close();
        return builder.toString();
    }

}
