package stream;

import org.junit.Test;

import java.util.Optional;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Optional1 {
    @Test
    public void test1(){
        Optional<String> optional =Optional.of("helloWorld");
        System.out.println(optional.isPresent());
        optional.getClass();
         boolean  b=optional.equals("hahah");
        System.out.println(b);

        String str=optional.orElse("您好，世界");
        System.out.println(str);

        optional.ifPresent(s-> System.out.println(s.length()));
    }
}
