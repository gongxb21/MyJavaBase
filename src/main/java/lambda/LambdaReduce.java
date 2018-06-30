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
public class LambdaReduce {

    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        double total = 0;

        total = list.stream().map(num -> num * 1.1).reduce((sum, num2) -> sum + num2).get();
        System.out.println(total);
    }
}
