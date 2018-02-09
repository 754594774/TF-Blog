package com.linn.home.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章分类实体类
 * @Author:LNN 2017-12-28 下午 2:07
 */
public class Category implements Serializable{

	private Integer id;
	private String intro;
	private String title;
	private Date gmtCreate;
	private Date gmtModified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
				", intro='" + intro + '\'' +
				", title='" + title + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				'}';
	}
}
