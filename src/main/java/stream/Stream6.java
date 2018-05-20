package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream6 {

    static  class Foo{
        String name;
        List<Bar> bars=new ArrayList<>();
        Foo(String name){
            this.name=name;
        }

    }

    static  class Bar{
        String name;
        Bar(String name){
            this.name=name;
        }
    }

    @Test
    public void test1(){
        List<Foo> list =new ArrayList<>();
        IntStream.range(0,4)
                .forEach(num->list.add(new Foo("Foo"+num) ));

        list.forEach(f->IntStream.range(0,4)
                .forEach(num->f.bars.add(new Bar("Bar" + num + " <- " + f.name))));

        list.stream()
                .flatMap(f->f.bars.stream())
                .forEach(b-> System.out.println(b.name));
    }

    @Test
    public void test2(){
        IntStream.range(0,4)
                .mapToObj(num->new Foo("Foo"+num))
                .peek(f->IntStream.range(0,4)
                        .mapToObj(num->new Bar("Bar"+num+"<-"+f.name))
                        .forEach(f.bars::add))
                .flatMap(f->f.bars.stream())
                .forEach(b-> System.out.println(b.name));
    }

}
