package xstream.simple;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * @author gongxb
 *
 * 2018��1��7��
 */
public class XStreamTest {
	
	@Test
	public void obj2xml() throws FileNotFoundException {
		XstreamSample.obj2xml();
	}
	
	public void xml2obj() throws FileNotFoundException {
		XstreamSample.xml2obj();
	}
}
