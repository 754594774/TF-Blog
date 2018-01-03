package com.linn.home.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章实体类
 * @Author:LNN 2018-01-02 下午 5:53
 */
public class Article implements Serializable{

	private Integer id;
	private Integer category_id;
	private String title;
	private String author;
	private String content;
	private Date gmtCreate;
	private Date gmtModified;
	private Integer sort_no;
	private Integer is_stick;
	private Integer is_draft;
	private Integer is_deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Integer getSort_no() {
		return sort_no;
	}

	public void setSort_no(Integer sort_no) {
		this.sort_no = sort_no;
	}

	public Integer getIs_stick() {
		return is_stick;
	}

	public void setIs_stick(Integer is_stick) {
		this.is_stick = is_stick;
	}

	public Integer getIs_draft() {
		return is_draft;
	}

	public void setIs_draft(Integer is_draft) {
		this.is_draft = is_draft;
	}

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", category_id=" + category_id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", content='" + content + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				", sort_no=" + sort_no +
				", is_stick=" + is_stick +
				", is_draft=" + is_draft +
				", is_deleted=" + is_deleted +
				'}';
	}
}
