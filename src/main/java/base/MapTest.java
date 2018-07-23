package base;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ����Map��
 *
 * @author gongxb
 * 2017��12��3��
 */
public class MapTest {
    public Map map;
    public static final int MAP_SIZE = 10;

    @Before
    public void intiMap() {
        System.out.println("inti start");
        map = new HashMap<String, String>(MAP_SIZE);
        for (int i = 0; i <= MAP_SIZE; i++) {
            String str = String.valueOf(i);
            map.put(str, str);
        }
        System.out.println(map.size());
        System.out.println("inti end");
    }

    @Test
    /**
     * void
     * TODO ͨ��keyset����Map ���Ƽ�ʹ�� ��������μ���
     */
    public void forEachByKeyset() {
        System.out.println("foreach by keySet start ");
        Set<String> set = map.keySet();
        for (String str : set) {
            System.out.println(map.get(str));
        }
        System.out.println("foreach by keySet end ");
    }

    @Test
    /**
     * void
     * TODO  ͨ��entrySet����Map �Ƽ�ʹ��
     */
    public void forEachByEntryset() {
        System.out.println(" for each by entrySet start");
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> obj : set) {
            System.out.println(obj.getValue());
        }
        System.out.println("foreach by entrySet end ");
    }

    /**
     * void
     * TODO ͨ��forEach ����Map ʹ����java8
     */
    @Test
    public void forEachByforEach() {
        System.out.println(" foreach by forEach start");
        map.forEach((k, v) -> System.out.println("key : " + k + "; value : " + v));
        System.out.println(" foreach by forEach end");
    }
}
