package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Cat;
import model.bean.Contact;
import model.bean.News;

@Repository
public class ContactDao {
	@Autowired
	private JdbcTemplate jdbcTemplates;
 
	public List<Contact> getItemNoReply(){
		String sql = "select * from vnecontact where reply = 0";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
	}
	

	public List<Contact> getItemReplied(){
		String sql = "select * from vnecontact where reply = 1";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
	}
	
	public int addItem(Contact contact) {
		String sql = "insert into vnecontact (fullname, email, subject, content) values(?,?,?,?)";
		return jdbcTemplates.update(sql, new Object[] {contact.getFullname(), contact.getEmail(), contact.getSubject(), contact.getContent()});
	}
	
	public int replyItem(int id) {
		String sql ="update vnecontact set reply = 1 where cid = ?";
		return jdbcTemplates.update(sql, new Object[] {id});
	}
	
	public int activeItem(int id, int active) {
		String sql ="update vnecontact set active = ? where cid = ?";
		return jdbcTemplates.update(sql, new Object[] {active, id});
	}
	
	public int delItem(int id) {
		String sql ="delete from vnecontact where cid = ?";
		return jdbcTemplates.update(sql, new Object[] {id});
	}


	public Contact getItemById(int id) {
		try {
			String sql = "select * from vnecontact where cid = ?";
			return (Contact) jdbcTemplates.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Contact>(Contact.class));
		}catch(Exception e) {
			return null;
		}
	}


	public List<Contact> getItemRe(){
		String sql = "select * from vnecontact where active = 0";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	
}
