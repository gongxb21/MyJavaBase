package xstream.simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author gongxb
 *
 * 2018年1月7日
 */
public class XstreamSample {
	private static XStream xstream;
	static {
		xstream=new  XStream(new DomDriver());
		xstream.alias("user", User.class);
		xstream.aliasField("myId", User.class,"id");
		//xstream.addImplicitCollection(User.class, "score");
	}
	/**
	 * 实例化User对象
	 * @return
	 * User
	 */
	public static User getUser() {
		List<String> list=new ArrayList<String>();
		list.add("100");
		list.add("90");
		list.add("80");
		Date date=new Date(System.currentTimeMillis());
		return new User("1","name","password",list,date);
	}
	
	public static void obj2xml() throws FileNotFoundException {
		System.out.println("obj2xml start");
		User user=getUser();
		FileOutputStream outputStream =new FileOutputStream("C:\\Users\\Administrator\\Desktop\\xstreamSample.xml");
		xstream.toXML(user,outputStream);
		System.out.println("obj2xml end");
	}
	
	public static void xml2obj() throws FileNotFoundException {
		System.out.println("xml2obj start");
		FileInputStream inputStream =new FileInputStream("C:\\Users\\Administrator\\Desktop\\xstreamSample.xml");
		User user=(User) xstream.fromXML(inputStream);
		System.out.println(user);
	}
}
