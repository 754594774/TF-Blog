package com.linn.home.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知实体类
 * @Author:LNN 2018-01-09 下午 4:09
 */
public class Notice implements Serializable{
	private Integer id;
	private String title;
	private String content;
	private String author;
	private Integer isActice;
	private Date gmtCreate;
	private Date gmtModified;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public Integer getIsActice() {
		return isActice;
	}

	public void setIsActice(Integer isActice) {
		this.isActice = isActice;
	}

	@Override
	public String toString() {
		return "Notice{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", author='" + author + '\'' +
				", isActice='" + isActice + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				'}';
	}
}
