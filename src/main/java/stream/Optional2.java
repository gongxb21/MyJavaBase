package stream;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Optional2 {

    static class Outer {
        Nested nested = new Nested();

        public Nested getNested() {
            return nested;
        }
    }

    static class Nested {
        Inner inner = new Inner();

        public Inner getInner() {
            return inner;
        }
    }

    static class Inner {
        String str = "hello";

        public String getStr() {
            return str;
        }
    }

    public static void test1() {
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.str))
                .ifPresent(s -> System.out.println(s));
    }


    public static void test2() {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getStr)
                .ifPresent(System.out::println);
    }

    public static void test3() {
        Outer out = new Outer();
        resolve(() -> out.getNested().getInner().getStr())
                .ifPresent(System.out::println);

    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

}
