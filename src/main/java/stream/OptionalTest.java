package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class OptionalTest {
    @Test
    public void test1() {
        Optional<String> optional = Optional.of("helloWorld");
        System.out.println(optional.isPresent());
        optional.getClass();
        boolean b = optional.equals("hahah");
        System.out.println(b);

        String str = optional.orElse("您好，世界");
        System.out.println(str);

        optional.ifPresent(s -> System.out.println(s.length()));
    }

    @Test
    public void testIsNull() {
        System.out.println(isNull(""));
        System.out.println(isNull(null));
        System.out.println(isNull("1"));
        System.out.println(isNull("string"));
    }

    @Test
    public void testIsEmpty() {
        System.out.println(isEmpty());
    }

    @Test
    public void testIsPresent() {
        System.out.println(Optional.of("hahah").isPresent());
        System.out.println(Optional.of("null").isPresent());
        System.out.println(Optional.of("").isPresent());
        System.out.println(Optional.ofNullable(null).isPresent());
    }

    @Test
    public void testIfPresent() {
        Optional.ofNullable(null).ifPresent(System.out::println);
        Optional.ofNullable("").ifPresent(System.out::println);
        Optional.ofNullable("123").ifPresent(System.out::println);
        Optional.ofNullable("helloworld").ifPresent(System.out::println);
    }

    @Test
    public void testFilter() {
        Optional<String> opt = Optional.ofNullable("hellowrold");
        opt.map(s -> s.toUpperCase()).filter(s -> s.contains("d")).ifPresent(System.out::println);
        opt.map(s -> s.toUpperCase()).filter(s -> s.contains("D")).ifPresent(System.out::println);
        System.out.println(opt.map(s -> s.toUpperCase()).filter(s -> s.contains("D")).get());
    }

    @Test
    public void testStringJoin() {
        System.out.println(String.join(" ", "hello", "world"));
        List<String> list = new ArrayList<>(10);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(String.join(" ", list));
    }


    private String isNull(String str) {
        return Optional.ofNullable(str).orElse("this is null");
    }

    private String isEmpty() {
        return Optional.empty().orElse("is empty").toString();
    }


}
