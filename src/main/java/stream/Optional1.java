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
        optional.equals("hahah");
        optional.orElse("您好，世界");

        optional.ifPresent(s-> System.out.println(s.length()));
    }
}
