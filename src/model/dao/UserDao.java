package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Roles;
import model.bean.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplates;
	
	public List<User> getItems(){
		String sql = "select * from users where enable = 1 order by id desc";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	public int editItem(User user) {
		String sql = "update users set fullname = ?, password = ?, role_id = ? where id = ?";
		return jdbcTemplates.update(sql, new Object[] {user.getFullname(), user.getPassword(), user.getRole_id(), user.getId()});
	}
	
	public int editProfile(User user) {
		String sql = "update users set fullname = ?, role_id = ? where id = ?";
		return jdbcTemplates.update(sql, new Object[] {user.getFullname(), user.getRole_id(), user.getId()});
	}

	public User getItem(int id) {
		try {
			String sql = "select * from users where id = ?";
			return jdbcTemplates.queryForObject(sql,new Object[] {id} , new BeanPropertyRowMapper<User>(User.class));
		}catch(Exception e) {
			return null;
		}
	}

	public int deleteItem(int id) {
		String sql = "delete from users where id = ?";
		return jdbcTemplates.update(sql, new Object[] {id});
	}

	public int addItem(User user) {
		String sql = "insert into users(username, fullname, password, enable, role_id) values(?, ?, ?, ?, ?)";
		return jdbcTemplates.update(sql, new Object[] {user.getUsername(), user.getFullname(), user.getPassword(), 1, user.getRole_id()} );
	}

	public int activeItem(int i, int j) {
		String sql = "update users enable = ? where id = ?";
		return jdbcTemplates.update(sql, new Object[] {j, i} );
	}

	public List<User> getItemRe(){
		String sql = "select * from users where enable = 0 order by id desc";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	public User getItemByUserName(String name) {
		try {
			String sql = "select * from users where username = ? and enable = 1";
			return jdbcTemplates.queryForObject(sql,new Object[] {name} , new BeanPropertyRowMapper<User>(User.class));
		}catch(Exception e) {
			return null;
		}
	}


}
