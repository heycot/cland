package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Cat;

@Repository
public class CatDao {
	@Autowired
	private JdbcTemplate jdbcTemplates;
	
	public List<Cat> getItems(){
		String sql = "select * from categories order by cid desc";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<Cat>(Cat.class));
	}

	public int addItem(Cat cat) {
		String sql = "insert into categories (cname) values(?)";
		return jdbcTemplates.update(sql, new Object[] {cat.getCname()});
	}

	public int deleteItem(int id) {
		String sql = "delete from categories where cid = ?";
		return jdbcTemplates.update(sql, new Object[] {id} );
	}

	public Cat getItem(int id) {
		try {
			String sql = "select * from categories where cid = ?";
			return (Cat) jdbcTemplates.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Cat>(Cat.class));
		}catch(Exception e) {
			return null;
		}
	}

	public int editItem(Cat cat) {
		String sql = "update categories set cname = ? where cid = ?";
		return jdbcTemplates.update(sql, new Object[] {cat.getCname(), cat.getCid()} );
	}


}
