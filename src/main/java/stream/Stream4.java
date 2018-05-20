package stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream4 {
    List<String> list;

    @Before
    public void init(){
        list =Arrays.asList("d2", "a2", "b1", "b3", "c");
    }

    @Test
    public void test1(){
        list.stream()
                .filter(s->{
                    System.out.println(s);
                    return true;
                })
                .forEach(System.out::println);
    }

    @Test
    public void test2(){
        list.stream()
                .map(s->s.toUpperCase())
                .filter(s->s.startsWith("A"))
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        list.stream()
                .filter(s->s.startsWith("a"))
                .map(s->s.toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        list.stream()
                .sorted((s1,s2)->s1.compareTo(s2))
                .filter(s->{
                    return s.toLowerCase().startsWith("a");
                })
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        list.stream()
                .filter(s->{
                    return s.toLowerCase().startsWith("b");
                })
                .sorted((a,b)->a.compareTo(b))
                .map(s->s.toUpperCase())
                .forEach(System.out::println);
    }


    @Test
    public void test6(){
        boolean flag=list.stream()
                .map(s->s.toUpperCase())
                .anyMatch(s->s.startsWith("A"));
        System.out.println(flag);
        list.forEach(System.out::println);

    }

    @Test
    public void test7(){
        Stream<String> str=list.stream()
                .filter(s->s.startsWith("a"));
        boolean flag;
//        flag=str.anyMatch(s->true);
//        System.out.println(flag);
        flag=str.noneMatch(s->true);
        System.out.println(flag);

    }

    @Test
    public void test8(){
       Supplier<Stream<String>>streamSupplier= ()->list.stream()
                .filter(s->s.startsWith("a"));

       streamSupplier.get().anyMatch(s->true);
       streamSupplier.get().noneMatch(s->true);
    }

}
