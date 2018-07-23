package base;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author gongxb
 * <p>
 * 2017��12��10��
 */
public class LocaleTest {
    public static Locale loc;

    /**
     * �õ�Ĭ�ϵ����Ի���
     * void
     */
    @Test
    public void getDefault() {
        loc = Locale.getDefault();
        System.out.println(loc);
    }

    /**
     * ���ֵ�ת��
     * <p>
     * void
     */
    @Test
    public void localeTest() {
        Locale locale = new Locale("zh", "CN");
        NumberFormat fm = NumberFormat.getCurrencyInstance(locale);
        double num = 12345.789;
        System.out.println(fm.format(num));
    }
}
