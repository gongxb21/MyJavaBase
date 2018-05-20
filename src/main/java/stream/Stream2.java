package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxb
 * @date 2018/5/20
 * @desc
 * @return
 */
public class Stream2 {
    public static  final int MAX=1000;

    public static  void sortSequential(){
        List<String> list=new ArrayList<>(MAX);
        for(int i=0;i<MAX;i++){
            UUID uuid=UUID.randomUUID();
            list.add(uuid.toString());
        }

        long t0=System.nanoTime();
        long count=list.stream().sorted().count();
        System.out.println("count="+count);

        long t1=System.nanoTime();
        long millis= TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static  void sortParallel(){
        List<String> list=new ArrayList<>(MAX);
        for(int i=0;i<MAX;i++){
            UUID uuid=UUID.randomUUID();
            list.add(uuid.toString());
        }

        long t0=System.nanoTime();
        long count=list.parallelStream().sorted().count();
        System.out.println("count="+count);

        long t1=System.nanoTime();
        long millis= TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    public static void main(String[] args) {
        sortParallel();
        sortSequential();
    }


}
