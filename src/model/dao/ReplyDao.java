package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.ReplyContact;

@Repository
public class ReplyDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplates;
 
	public List<ReplyContact> getItems(){
		String sql = "select rid, user_id, content, contact_id, users.username from replycontact inner join users on replycontact.user_id = users.id";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<ReplyContact>(ReplyContact.class));
	}
	
	public int delItem(int id) {
		String sql ="delete from replycontact where rid = ?";
		return jdbcTemplates.update(sql, new Object[] {id});
	}
	
	public int activeItem(int id, int active) {
		String sql ="update replycontact set active = ? where rid = ?";
		return jdbcTemplates.update(sql, new Object[] {active, id});
	}
	
	public int addItem(ReplyContact reply) {
		String sql ="insert into replycontact(user_id, content, contact_id) value(?, ?, ?)";
		return jdbcTemplates.update(sql, new Object[] {reply.getUser_id(), reply.getContent(), reply.getContact_id()});
	}

}
