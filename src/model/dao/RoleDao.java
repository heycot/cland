package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Roles;

@Repository
public class RoleDao {
	@Autowired
	private JdbcTemplate jdbcTemplates;
	
	public List<Roles> getItems(){
		String sql = "select * from roles ";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<Roles>(Roles.class));
	}

	
}
