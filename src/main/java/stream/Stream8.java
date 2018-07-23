package stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream8 {
    List<Person> persons = new ArrayList<>();

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Before
    public void init() {
        persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 24),
                new Person("Pamela", 23),
                new Person("David", 12));
    }


    @Test
    public void test1() {
        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        Person result = persons.stream()
                .reduce(new Person("", 0), (p1, p2) ->
                {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });
        System.out.format("name=%s; age=%s", result.name, result.age);
    }

    @Test
    public void test3() {
        Integer i = persons.stream()
                .reduce(0, (sum, p) -> sum += p.age
                        , (sum1, sum2) -> sum1 + sum2
                );
        System.out.println(i);
    }


    @Test
    public void test4() {
        Integer ageNum = persons.stream()
                .reduce(0, (sum, p) -> sum + p.age, (sum1, sum2) -> sum1 + sum2);
        System.out.println(ageNum);
    }

    @Test
    public void test5() {
        Integer ageSum = persons.parallelStream()
                .reduce(0, (sum, p) -> {
                    return sum + p.age;
                }, (sum, sum2) -> {
                    return sum + sum2;
                });

        System.out.println(ageSum);
    }

    @Test
    public void test6() {
        Integer ageSum = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s; thread=%s\n",
                                    sum, p, Thread.currentThread().getName());
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s; thread=%s\n",
                                    sum1, sum2, Thread.currentThread().getName());
                            return sum1 + sum2;
                        });

        System.out.println(ageSum);
    }


}


