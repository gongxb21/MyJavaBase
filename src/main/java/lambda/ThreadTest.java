package lambda;

import org.junit.Test;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class ThreadTest {

    /**
     * 匿名类的线程实现
     */
    @Test
    public void testOld() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is old Thread");
            }
        }).start();
    }

    /**
     * lambda 的线程实现
     */
    @Test
    public void testNew() {
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }




}
