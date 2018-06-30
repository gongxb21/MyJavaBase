package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class LambdaStream {
    @Test
    public void testStream(){
        List<Integer> list= Arrays.asList(100,200,300,400);
        list.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
        list.stream().map((num)->num +1).forEach(System.out::println);
    }
}
