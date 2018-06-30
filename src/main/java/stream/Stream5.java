package stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc 几种球平均值的方法
 * @return
 */
public class Stream5 {
    @Test
    public void test1(){
        int[] ints={1,3,5,6,9,12};
        Arrays.stream(ints)
                .max()
                .ifPresent(System.out::println);
    }

    @Test
    public void test2(){
        IntStream.builder()
                .add(1)
                .add(2)
                .add(4)
                .add(12)
                .add(15)
                .build()
                .average()
                .ifPresent(s-> System.out.println(s));
    }

    @Test
    public void test3(){
        IntStream.range(0,20)
                .average()
                .ifPresent(System.out::println);
    }


    @Test
    public void test4(){
        Stream.of(new BigDecimal(1.2),new BigDecimal(3.9))
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .ifPresent(System.out::println);
    }

}
