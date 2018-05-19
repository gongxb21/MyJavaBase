package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestOnReflect {
	public static void main(String[] args) throws Exception {
		//Class c=Person.class;
		//Class c=Class.forName("reflection.Person");
		Class c=new Person().getClass();
		//得到所有的构造方法
		Constructor[] cons=c.getDeclaredConstructors();
		System.out.println(cons.length);
		for(int i=0;i<cons.length;i++) {
			System.out.println(cons[i]);
			
		}
		
		//得到所有的方法
		System.out.println("c.getMethods():"+c.getMethods());
		Method[] ms=	c.getDeclaredMethods();
		System.out.println(ms.length);
		for(int i=0;i<ms.length;i++) {
			System.out.println(ms[i]);
		}
		System.out.println("=====================");
		Method s=c.getMethod("getJob");
		System.out.println(s);
		
		System.out.println("=====================");
		Class cls=c.getSuperclass();
		System.out.println(cls.getName());
		
		System.out.println("===========================");
		Class[] is=c.getInterfaces();
		System.out.println(is.length);
		
		for(int i=0;i<is.length;i++) {
			System.out.println(is[i]);
		}
		
		System.out.println("===========================");
		Class[] cs=c.getClasses();
		System.out.println("cs.length:"+cs.length);
		for(int i=0;i<cs.length;i++) {
			System.out.println(cs[i]);
		}
	}
}
