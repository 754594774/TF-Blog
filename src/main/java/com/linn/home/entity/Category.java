package com.linn.home.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章分类实体类
 * @Author:LNN 2017-12-28 下午 2:07
 */
public class Category implements Serializable{

	private int id;
	private String description;
	private String name;
	private Date gmtCreate;
	private Date gmtModified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", description='" + description + '\'' +
				", name='" + name + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				'}';
	}
}
