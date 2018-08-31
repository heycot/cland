package model.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	private int id;
	@Size(min = 10, max = 100)
	private String username;
	@Size(min = 10, max = 100)
	private String fullname;
	@Size(min = 6, max = 20)
	private String password;
	private int enable;
	private int role_id;
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int id, String username, String fullname, String password) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String fullname, String password, int enable, int role_id) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.enable = enable;
		this.role_id = role_id;
	}
	public User(int id, String username, String fullname, String password, int enable, int role_id, String email) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.enable = enable;
		this.role_id = role_id;
		this.email = email;
	}
	
	

}
