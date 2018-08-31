package model.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class News {

	private int lid;
	@NotBlank
	private String lname;
	@NotBlank
	private String description;
	private Timestamp date_create;
	private int cid;
	@NotNull
	private String picture;
	private int area;
	@NotBlank
	private String address;
	private int count_views;
	private String cname;
	private int active;
	
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount_views() {
		return count_views;
	}
	public void setCount_views(int count_views) {
		this.count_views = count_views;
	}
	public News(int lid, String lname, String description, Timestamp date_create, int cid, String picture, int area,
			String address, int count_views) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.date_create = date_create;
		this.cid = cid;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(int lid, String lname, String description, Timestamp date_create, int cid, String picture, int area,
			String address, int count_views, String cname) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.date_create = date_create;
		this.cid = cid;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
		this.cname = cname;
	}
	public News(int lid, String lname, String description, Timestamp date_create, int cid, String picture, int area,
			String address, int count_views, String cname, int active) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.date_create = date_create;
		this.cid = cid;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
		this.cname = cname;
		this.active = active;
	}
	
	
	
	
}
