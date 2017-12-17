package base;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

/**
 * 
 * @author gongxb
 *
 * 2017年12月10日
 */
public class LocaleTest {
	public static Locale loc;
	/**
	 * 得到默认的语言环境
	 * void
	 */
	@Test
	public void getDefault() {
		 loc=Locale.getDefault();
		System.out.println(loc);
	}
	/**
	 * 数字的转换
	 * 
	 * void
	 */
	@Test
	public void localeTest() {
		Locale locale=new Locale("zh","CN");
		NumberFormat fm=NumberFormat.getCurrencyInstance(locale);
		double num=12345.789;
		System.out.println(fm.format(num));
	}
}
