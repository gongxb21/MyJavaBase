package xstream.simple;

import java.sql.Date;
import java.util.List;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ7ÈÕ
 */
public class User {
	private String id;
	private String name;
	private String password;
	private List<String> score;
	private Date date;
	
	public List<String> getScore() {
		return score;
	}
	public void setScore(List<String> score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public User(String id, String name, String password,List<String> score,Date date) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.score=score;
		this.date=date;
	}
	
}
