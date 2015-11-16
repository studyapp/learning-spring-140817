package com.yapp.urlshorter.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yapp.urlshorter.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	public static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
	@Autowired JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> userRowMapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDate(4));
		}
	};

	@Override
	public int save(User user) {
		String sql = "INSERT INTO user_tbl (username, password) VALUES (?, password(?))";
		
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		String sql = "SELECT * FROM user_tbl WHERE username=? AND password=password(?)";
		
		return queryForUser(sql, username, password);
	}
	
	@Override
	public User findUserByUsername(String username) {
		String sql = "SELECT * FROM user_tbl WHERE username=?";
		
		return queryForUser(sql, username);
	}
	
	private User queryForUser(String sql, Object... args) {
		try {
			return jdbcTemplate.queryForObject(sql, userRowMapper, args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
