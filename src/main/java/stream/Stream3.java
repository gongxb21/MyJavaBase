package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc 关于IntStream 的一些用法
 * @return
 */
public class Stream3 {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
        System.out.println("====1====");
        IntStream.range(0,10)
                .forEach(i->{ if(i%2==0){
                        System.out.println(i);
                    }
                });
        System.out.println("====2=");
        IntStream.range(0,10)
                .forEach(i->{
                    if(i%2==1){
                        System.out.println(i);
                    }
                });

        System.out.println("====3===");

        IntStream.range(0,10)
                .filter(i->i%2==0)
                .forEach(System.out::println);

        System.out.println("====4=====");

        OptionalInt red=IntStream.range(0,10)
                .reduce((a,b)->a+b);
        System.out.println(red.getAsInt());

        System.out.println("===5===");

        int red2=IntStream.range(0,10)
                .reduce(-45,(a,b)->a+b);
        System.out.println(red2);
    }
}
