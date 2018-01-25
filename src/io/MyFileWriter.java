/**
 * 
 */
package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gongxb
 * @date 2018-1-25  ÐÂ½¨ 
 */
public class MyFileWriter {
	private FileWriter fw;
	public void write() throws IOException{
		fw=new FileWriter(new File("D:"+File.separator+"afdsaf.txt"));
		fw.write("adfsafsdafasfdsdafsafsafsadfsadfsadfsfasafsafdsfsadf");
		fw.flush();
		fw.close();
	}
}
