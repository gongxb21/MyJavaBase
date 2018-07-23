package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class LambdaString {
    @Test
    public void testString() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "ad", "acf");
        List<String> filtered = list.stream().filter(str -> str.length() >= 2).collect(Collectors.toList());
        filtered.forEach(s -> System.out.println(s));
    }

    @Test
    public void testUpper() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "ad", "acf");
        String s = list.stream().map(str -> str.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(s);
        System.out.println("===============");
        List<String> sList = list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        sList.forEach(str -> System.out.println(str));
    }

    @Test
    public void testDistinct() {
        List<Integer> list = Arrays.asList(1, 2, 2, 87, 6, 9);
        List<Integer> distinct = list.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        list.forEach(s -> System.out.println(s));
        System.out.println("=============");
        distinct.forEach(s -> System.out.println(s));
    }

    @Test
    public void testMax() {
        List<Integer> list = Arrays.asList(1, 2, 2, 87, 6, 9);
        IntSummaryStatistics statistics = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("max=" + statistics.getMax());
        System.out.println("min=" + statistics.getMin());
        System.out.println("avg=" + statistics.getAverage());

    }


}
