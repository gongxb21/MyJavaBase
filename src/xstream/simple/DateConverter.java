package xstream.simple;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ7ÈÕ
 */
public class DateConverter implements Converter {
	private Locale locale;
	private DateConverter(Locale locale) {
		super();
		this.locale=locale;
	}
	@Override
	public boolean canConvert(Class clazz) {
		return Date.class.isAssignableFrom(clazz);
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext contex) {
		DateFormat df=DateFormat.getDateInstance(DateFormat.DATE_FIELD, locale);
		writer.setValue(df.format(obj));
	
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		GregorianCalendar calender =new GregorianCalendar();
		DateFormat formatter =DateFormat.getDateInstance(DateFormat.DATE_FIELD,locale);
		try {
			calender.setTime(formatter.parse(reader.getValue()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calender.getGregorianChange();
	}

}
