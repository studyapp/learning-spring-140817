package com.yapp.urlshorter.entity;

import java.util.Date;

public class Url {

	/**
	 * DB Id
	 */
	private long id;
	
	/**
	 * 원본 URL 주소
	 */
	private String url;

	/**
	 * 접속 횟수
	 */
	private int count;

	/**
	 * 생성한 사용자
	 */
	private long userId;
	
	private Date created;

	public Url(long id, String url, int count, long userId, Date created) {
		this.id = id;
		this.url = url;
		this.count = count;
		this.userId = userId;
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Url [url=" + url + ", id=" + id + ", count=" + count
				+ ", userId=" + userId + "]";
	}

}
