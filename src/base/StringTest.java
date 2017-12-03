package base;
import java.util.Observer;
/**
 * 
 * @author gongxb
 * 2017年12月3日
 */
public class StringTest {
	public static void main(String[] args) {
		String s="helloworld";
		// intern 方法
		System.out.println(s.intern());
	}
}
