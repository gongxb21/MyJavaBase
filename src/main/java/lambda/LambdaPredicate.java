package lambda;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class LambdaPredicate {

    static List<String> list = new ArrayList();

    public static void initList() {
        list.add("apple");
        list.add("banana");
        list.add("peach");
        list.add("Java");

    }

    public static void filter(List<String> list, Predicate condition) {

        for (String name : list) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    /**
     * 以流的形式 遍历集合
     * @param names
     * @param condition
     */
    public static void filterLambda(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }


    public static void main(String[] args) {
        initList();
        filter(list, (str) -> true);
        System.out.println("========");
        //filterLambda(list,str->str.startWith("a"));
        //不知道为什么这个不好用
      //  filter(list, (str) -> str.startWith("s"));
       // filter(list, (str) -> str.endsWith("a"));
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，


    }




}
