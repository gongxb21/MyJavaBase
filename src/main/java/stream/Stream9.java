package stream;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream9 {
    @Test
    public void test1(){
        SecureRandom secureRandom=new SecureRandom(new byte[]{1,2,3});
        int[] randoms= IntStream.generate(secureRandom::nextInt)
                .filter(n->n>0)
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(randoms));
        System.out.println("=============");
        int[] nums=IntStream.iterate(1,n->n*2)
                .limit(11)
                .toArray();
        System.out.println(Arrays.toString(nums));
    }
}
