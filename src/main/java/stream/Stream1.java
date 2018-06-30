package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("Ccc");
        list.add("bbb2");
        list.add("ddd1");

        //filter
        list.stream().filter(s->s.startsWith("d"))
                .forEach(s-> System.out.println(s));
        System.out.println("====1====");

        //sort
        list.stream().sorted()
                .forEach(s-> System.out.println(s));

        System.out.println("====2======");

        //mapping
        list.stream()
                .map(String::toUpperCase)
                .forEach(s-> System.out.println(s));

        System.out.println("=====3=====");

        //matching

       boolean anyStartWith= list.stream()
                .anyMatch(s->s.startsWith("a"));

        System.out.println(anyStartWith);

        boolean allStartWith=list.stream()
                .allMatch(s->s.startsWith("a"));
        System.out.println(allStartWith);

        //counting

        long  count=list.stream()
                .filter(s->s.startsWith("d"))
                .count();
        System.out.println(count);
        System.out.println("====4=====");
        //reducing

       Optional<String> red= list.stream().sorted()
                .reduce((s1,s2)->s1+":"+s2);
       red.ifPresent(System.out::println);
        System.out.println("====5===");

       list.stream()
               .sorted()
               .forEach(System.out::println);

    }
}
