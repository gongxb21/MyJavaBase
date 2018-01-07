package xstream.annotation;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.basic.DateConverter;


/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ7ÈÕ
 */
@XStreamAlias("user")
public class User {
	@XStreamAsAttribute
	@XStreamAlias("id")
	private int id;
	
	@XStreamAlias("name")
	private String name;
	
	@XStreamAlias("password")
	private String password;
	
	@XStreamConverter(DateConverter.class)
	private Date lastVisit;
	
	@XStreamImplicit
	private List logs;

	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param lastVisit
	 * @param logs
	 */
	public User(int id, String name, String password, Date lastVisit, List logs) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.lastVisit = lastVisit;
		this.logs = logs;
	}
	
	
}
