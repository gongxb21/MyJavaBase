package genericity;

import org.junit.Before;
import org.junit.Test;

/**
 * @author gongxb
 * @date 2018/7/19
 * @desc
 * @return
 */
public class GeneratorTest {
    NumGenerator ng;
    StringGenerator sg;

    @Before
    public void init() {
        ng = new NumGenerator();
        sg = new StringGenerator();
    }

    @Test
    public void testPrint() {
        ng.print(123);
        sg.print("helloWorld");
    }
}
