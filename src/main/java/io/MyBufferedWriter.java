package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gongxb
 * @date 2018-1-25  �½�
 */
public class MyBufferedWriter {
    private BufferedWriter bw;

    public void buffferWriter() throws IOException {
        bw = new BufferedWriter(new FileWriter(new File("D:/asdf.abc")));
        bw.write("asdffggggg");
        bw.flush();
        bw.close();
    }
}
