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
    public void testReduce(){
        List<Integer> list = Arrays.asList(100,200,300,400,500,600);
        double total=0;

       total= list.stream().map(num->num*1.1).reduce((sum,num)->sum+num).get();
        System.out.println(total);
    }
}
