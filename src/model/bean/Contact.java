package model.bean;

import org.hibernate.validator.constraints.NotBlank;

public class Contact {
	
	private int cid;
	@NotBlank
	private String fullname;
	@NotBlank
	private String email;
	@NotBlank
	private String subject;
	@NotBlank
	private String content;
	private int reply;
	private int active;
	
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int icd) {
		this.cid = icd;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public Contact(int icd, String fullname, String emmail, String subject, String content, int reply) {
		super();
		this.cid = icd;
		this.fullname = fullname;
		this.email = emmail;
		this.subject = subject;
		this.content = content;
		this.reply = reply;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int icd, String fullname, String email, String subject, String content, int reply, int active) {
		super();
		this.cid = icd;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.reply = reply;
		this.active = active;
	}
	
	

}
