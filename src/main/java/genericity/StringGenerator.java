package genericity;

/**
 * @author gongxb
 * @date 2018/7/19
 * @desc
 * @return
 */
public class StringGenerator implements Generator<String> {

    @Override
    public String print(String s) {
        System.out.println("StringGenerator.print =" + s);
        return s;
    }
}
