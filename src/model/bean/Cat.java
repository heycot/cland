package model.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Cat {
	private int cid;
	@NotEmpty
	@Size(min = 5, max = 20)
	private String cname;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Cat() {
		super();
	}
	public Cat(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
}
