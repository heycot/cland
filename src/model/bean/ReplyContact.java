package model.bean;

import org.hibernate.validator.constraints.NotBlank;

public class ReplyContact {
	
	private int rid;
	private int user_id;
	@NotBlank
	private String content;
	private int contact_id;
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public ReplyContact(int rid, int username, String content, int contact_id) {
		super();
		this.rid = rid;
		this.user_id = username;
		this.content = content;
		this.contact_id = contact_id;
	}
	public ReplyContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyContact(int rid, int user_id, String content, int contact_id, String username) {
		super();
		this.rid = rid;
		this.user_id = user_id;
		this.content = content;
		this.contact_id = contact_id;
		this.username = username;
	}
}
