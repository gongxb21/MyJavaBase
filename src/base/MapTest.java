package base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

import org.junit.Before;
import org.junit.Test;
/**
 * 测试Map类
 * @author gongxb
 * 2017年12月3日
 */
public class MapTest {
	public Map map;
	public static final int MAP_SIZE=10;
	
	@Before
	public void intiMap() {
		System.out.println("inti start");
		map=new HashMap<String,String>(MAP_SIZE);
		for(int i=0;i<=MAP_SIZE;i++) {
			String str=String.valueOf(i);
			map.put(str, str);
		}
		System.out.println(map.size());
		System.out.println("inti end");
	}
	@Test
	/**
	 * void
	 * TODO 通过keyset遍历Map 不推荐使用 会遍历两次集合
	 */
	public void forEachByKeyset() {
		System.out.println("foreach by keySet start ");
		Set<String> set=map.keySet();
		for(String str:set) {
			System.out.println(map.get(str));
		}
		System.out.println("foreach by keySet end ");
	}
	
	@Test
	/**
	 * void
	 * TODO  通过entrySet遍历Map 推荐使用
	 */
	public void forEachByEntryset() {
		System.out.println(" for each by entrySet start");
		Set<Map.Entry<String, String>> set=map.entrySet();
		for(Map.Entry<String, String> obj:set) {
			System.out.println(obj.getValue());
		}
		System.out.println("foreach by entrySet end ");
	}
	/**
	 * void
	 * TODO 通过forEach 遍历Map 使用与java8
	 */
	@Test
	public void forEachByforEach() {
		System.out.println(" foreach by forEach start");
		map.forEach((k,v)->System.out.println("key : " + k + "; value : " + v));
		System.out.println(" foreach by forEach end");
	}
}
