package com.cdbt.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private Integer id;
	private String name;

	@JSONField(format = "yyyy-mm-dd")
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
