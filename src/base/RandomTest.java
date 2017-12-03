package base;

import java.util.Random;

import org.junit.Test;

/**
 * 测试随机数类
 * @author gongxb
 * 2017年12月3日
 */
public class RandomTest {
	/**
	 * 
	 * 产生随机数,int 类型
	 * void
	 */
	@Test
	public void getRandomInt() {
		double dou=Math.random();
		System.out.println(dou);
		int i=(int) Math.floor(dou*10);
		System.out.println(i);
	}
	/**
	 * 
	 * 产生随机数,int 类型 如果是产生随机整数，建议采用这种方法
	 * void
	 */
	@Test
	public void getRandomInt2() {
		System.out.println("getRandomInt2 start");
		Random ran=new Random();
		System.out.println(ran.nextInt(10));
		System.out.println("getRandomInt2 end ");
	}
	
}
