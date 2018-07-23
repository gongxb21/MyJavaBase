package genericity;

/**
 * @author gongxb
 * @date 2018/7/19
 * @desc
 * @return
 */
public class NumGenerator implements Generator<Integer> {

    @Override
    public Integer print(Integer s) {
        System.out.println("NumGenerator .print=" + s);
        return s;
    }

}
