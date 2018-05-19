/**
 * 
 */
package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author gongxb
 * @date 2018-1-25  ÐÂ½¨ 
 */
public class MyOutputStreamWriter {
	private static OutputStreamWriter ows;
	
	public  void write() throws IOException{
		ows=new OutputStreamWriter(new FileOutputStream(new File("D:"+File.separator+"dsfs.txt")));
		ows.write("safdsfsafsafsafsfdafd");
		ows.flush();
		ows.close();
	}
}
