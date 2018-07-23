package base;

import org.junit.Test;

import java.util.Random;

/**
 * �����������
 *
 * @author gongxb
 * 2017��12��3��
 */
public class RandomTest {
    /**
     * ���������,int ����
     * void
     */
    @Test
    public void getRandomInt() {
        double dou = Math.random();
        System.out.println(dou);
        int i = (int) Math.floor(dou * 10);
        System.out.println(i);
    }

    /**
     * ���������,int ���� ����ǲ����������������������ַ���
     * void
     */
    @Test
    public void getRandomInt2() {
        System.out.println("getRandomInt2 start");
        Random ran = new Random();
        System.out.println(ran.nextInt(10));
        System.out.println("getRandomInt2 end ");
    }

}
