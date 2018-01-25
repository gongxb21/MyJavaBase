/**
 * 
 */
package io;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

/**
 * @author gongxb
 * @date 2018-1-25  ÐÂ½¨ 
 */
public class IOtest {
	
	//@Test
	public void inputStream () throws IOException{
		MyInputStream is=new MyInputStream();
		MyInputStream.inputStream();
	}
	//@Test
	public void bufferedInputStream () throws IOException{
		MyInputStream is=new MyInputStream();
		MyInputStream.bufferInputStream();
	}
	//@Test
	public void outputStream() throws IOException {
		MyOutputStream os=new MyOutputStream();
		MyOutputStream.outputStream();
	}
	//@Test
	public void bufferedOutputStream() throws IOException {
		MyOutputStream os=new MyOutputStream();
		MyOutputStream.bufferedOutputStream();
	}
	
	//@Test
	public void inputStreamReader() throws MalformedURLException, IOException{
		MyInputStreamReader msr=new MyInputStreamReader();
		msr.read();
	}
	
	//@Test
	public void outputStreamWriter() throws IOException{
		MyOutputStreamWriter msw=new MyOutputStreamWriter();
		msw.write();
	}
	
	//@Test
	public void read() throws IOException{
		MyFileReader mfr=new MyFileReader();
		mfr.read();
	}
	//@Test
	public void write() throws IOException{
		MyFileWriter mfw=new MyFileWriter();
		mfw.write();
	}
	
	//@Test(timeout=10)
	public void bufferReader() throws IOException{
		long start=System.currentTimeMillis();
		MyBufferedReader mbr=new MyBufferedReader();
		mbr.readline();
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	//@Test
	public void bufferWriter() throws IOException{
		MyBufferedWriter mbw=new MyBufferedWriter();
		mbw.buffferWriter();
	}
	
	@Test
	public void interfaceTest() throws IOException{
		InterfaceTest it=new InterfaceTest();
		int i=it.getStringCount();
		System.out.println("the count is "+i);
	}
}
