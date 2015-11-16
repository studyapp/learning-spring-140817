package com.yapp.urlshorter.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yapp.urlshorter.entity.Url;

@Repository
public class UrlRepositoryImpl implements UrlRepository{
	public static final Logger logger = LoggerFactory.getLogger(UrlRepositoryImpl.class);
	
	@Autowired JdbcTemplate jdbcTemplate;
	
	RowMapper<Url> urlRowMapper = new RowMapper<Url>() {

		@Override
		public Url mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Url(rs.getLong(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getLong(4),
					rs.getDate(5));
		}
	};

	@Override
	public int save(String url, long userId) {
		String sql = "INSERT INTO url_tbl (url, user_id) VALUES (?, ?)";
		
		return jdbcTemplate.update(sql, url, userId);
	}

	@Override
	public Url findUrlById(long id) {
		String sql = "SELECT * FROM url_tbl WHERE id=?";
		
		return queryForUrl(sql, id);
	}

	@Override
	public List<Url> findUrlByUserId(long userId) {
		String sql = "SELECT * FROM url_tbl WHERE user_id=?";
		
		return queryForList(sql, userId);
	}
	
	private Url queryForUrl(String sql, Object... args) {
		try {
			return jdbcTemplate.queryForObject(sql, urlRowMapper, args);
		} catch (EmptyResultDataAccessException e) {
			// 조회 결과가 없는 경우 null을 반환
			return null;
		}
	}
	
	private List<Url> queryForList(String sql, Object... args) {
		try {
			return jdbcTemplate.query(sql, urlRowMapper, args);
		} catch(EmptyResultDataAccessException e) {
			// 조회 결과가 없는 경우 빈 리스트를 반환
			logger.info("없음");
			return new ArrayList<Url>();
		}
	}

	@Override
	public int increaseCount(long id) {
		String sql = "UPDATE url_tbl SET count=count+1 WHERE id=?";
		
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int deleteOne(long id) {
		String sql = "DELETE FROM url_tbl WHERE id=?";
		
		return jdbcTemplate.update(sql, id);
	}
}
