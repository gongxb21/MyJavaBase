package lambda;

import com.sun.org.apache.xml.internal.security.Init;
import org.junit.Test;

import java.util.*;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class LambdaForeach {

    List<String> list=new ArrayList();
    Map<String,String> map=new HashMap<String,String>();
    Set<String> set=new HashSet();

    public void initList(){
        list.add("apple");
        list.add("banana");
        list.add("peach");

    }

    public void initMap(){
        map.put("1","apple");
        map.put("2","banana");
        map.put("3","peach");
    }

    public void initSet(){
        set.add("apple");
        set.add("banana");
        set.add("peach");
    }

    @Test
   public void testForeach(){
        initList();
        initMap();
        initSet();

        list.forEach(n-> System.out.println(n));
        System.out.println("+++++++++++++++++++++");
        map.forEach((key,value)-> System.out.println(key+":"+value));
        System.out.println("+++++++++++++++++++++");
        set.forEach(n-> System.out.println(n));
   }
}
