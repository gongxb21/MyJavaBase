package base;
import java.util.Observer;
/**
 * 
 * @author gongxb
 * 2017年12月3日
 */
public class StringTest {
	public static void main(String[] args) {
		//intern();
		format();
	}

	/**
	 * 
	 * void
	 */
	private static void intern() {
		String s="helloworld";
		// intern 方法
		System.out.println(s.intern());
	}
	
	public static void format() {
		System.out.println(String.format("价格%d元", 10));
	}
}
