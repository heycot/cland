package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import constant.Defines;
import model.bean.News;

@Repository
public class NewsDao {
	@Autowired
	private JdbcTemplate jdbcTemplates;
	
	public List<News> getItems(int offset){
		String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where active = 1 order by lid desc limit ?, ?";
		return jdbcTemplates.query(sql, new Object[] {offset, Defines.row_count}, new BeanPropertyRowMapper<News>(News.class));
	}
	
	public List<News> getItemsPublic(int offset){
		String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where active = 1 order by lid desc limit ?, ?";
		return jdbcTemplates.query(sql, new Object[] {offset, Defines.row_count_public}, new BeanPropertyRowMapper<News>(News.class));
	}

	public int countItem() {
		String sql = "select count(*) from lands inner join categories on lands.cid = categories.cid where active = 1";
		return jdbcTemplates.queryForObject(sql, Integer.class);
		
	}
	public int addItem(News news) {
		String sql = "insert into lands (lname, description, cid, picture, area, address, count_views) values(?,?,?,?,?,?,?)";
		return jdbcTemplates.update(sql, new Object[] {news.getLname(), news.getDescription(), news.getCid(), news.getPicture(), news.getArea(), news.getAddress(), news.getCount_views()});
	}
	
	

	public int deleteItem(int id) {
		String sql = "delete from lands where lid = ?";
		return jdbcTemplates.update(sql, new Object[] {id} );
	}
	
	public int activeItem(int id, int active) {
		String sql = "update lands set active = ? where lid = ?";
		return jdbcTemplates.update(sql, new Object[] {active, id} );
	}


	public News getItem(int id) {
		try {
			String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where lid = ?";
			return (News) jdbcTemplates.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<News>(News.class));
		}catch(Exception e) {
			return null;
		}
	}

	public int editItem(News news) {
		String sql = "update lands set lname = ?, description = ?, cid = ?, picture = ?, area = ?, address = ? where lid = ?";
		return jdbcTemplates.update(sql, new Object[] {news.getLname(), news.getDescription(), news.getCid(), news.getPicture(), news.getArea(), news.getAddress(), news.getLid()} );
	}

	
	public List<News> getItemByIdCat(int id, int ofset){
		String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where lands.cid = ? order by lid desc limit ?, ? ";
		return jdbcTemplates.query(sql, new Object[] {id, ofset, Defines.row_count_cat}, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItemSameCat(int id) {
		String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where lands.cid = ? and active = 1 order by lid desc limit 0, 3 ";
		return jdbcTemplates.query(sql, new Object[] {id}, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItemRe(){
		String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where active = 0 order by lid desc ";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}

	public News getMinID() {
		try {
			String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where active = 1 order by lid asc limit 0,1";
			return (News) jdbcTemplates.queryForObject(sql, new BeanPropertyRowMapper<News>(News.class));
		}catch(Exception e) {
			return null;
		}
	}
	

	public News getMaxID() {
		try {
			String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where active = 1 order by lid desc limit 0,1";
			return (News) jdbcTemplates.queryForObject(sql, new BeanPropertyRowMapper<News>(News.class));
		}catch(Exception e) {
			return null;
		}
	}

	public List<News> getItemsCountView() {
		String sql = "select lid, lname, description, date_create, lands.cid, area, address, count_views, picture, cname from lands join categories on lands.cid = categories.cid where lands.active = 1 order by count_views desc limit 0, 4 ";
		return jdbcTemplates.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}
	

}
