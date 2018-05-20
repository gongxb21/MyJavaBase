package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream7 {
    @Test
    public void test(){
        Arrays.asList("1","2","4","9")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("a11","b22","c33","d44")
                .map(s->s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(0,4)
                .mapToObj(a->"a"+a)
                .forEach(System.out::println);

        Arrays.stream(new int[] {1,2,3,4})
                .map(n->n*2+1)
                .average()
                .ifPresent(System.out::println);


        Stream.of(1.0,2.0,3.0,4.0,5.0)
                .mapToInt(Double::intValue)
                .mapToObj(i->"a"+i)
                .forEach(System.out::println);

        Arrays.asList("a1", "a2", "b1", "c2", "c11")
                .stream()
                .filter(s->s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);



    }
}
