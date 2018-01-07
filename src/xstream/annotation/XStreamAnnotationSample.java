package xstream.annotation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ7ÈÕ
 */
public class XStreamAnnotationSample {
	private static XStream xstream ;
	static {
		xstream =new XStream(new DomDriver());
		xstream.processAnnotations(User.class);
	}
	
	public static User getUser() {
		Date date=new Date(System.currentTimeMillis());
		List logs=new ArrayList();
		logs.add("log1");
		logs.add("log2");
		logs.add("log3");
		return new User(1,"name","pwd",date,logs);
	}
	
	public static void obj2xml() throws FileNotFoundException {
		User user=getUser();
		FileOutputStream out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\xstreamSample2.xml");
		OutputStreamWriter  writer=new OutputStreamWriter(out);
		xstream.toXML(user,writer);
	}
	
}
