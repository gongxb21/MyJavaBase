package base;

/**
 * @author gongxb
 * 2017��12��3��
 */
public class StringTest {
    public static void main(String[] args) {
        //intern();
        format();
    }

    /**
     * void
     */
    private static void intern() {
        String s = "helloworld";
        // intern ����
        System.out.println(s.intern());
    }

    public static void format() {
        System.out.println(String.format("�۸�%dԪ", 10));
    }
}
