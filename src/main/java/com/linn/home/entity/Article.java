package com.linn.home.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章实体类
 * @Author:LNN 2018-01-02 下午 5:53
 */
public class Article implements Serializable{

	private Integer id;
	private Integer categoryId;
	private String title;
	private String author;
	private String intro;
	private String content;
	private Date gmtCreate;
	private Date gmtModified;
	private Integer sortNo;
	private Integer allowComment;
	private Integer isStick;
	private Integer isDraft;
	private Integer isDeleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Integer getIsStick() {
		return isStick;
	}

	public void setIsStick(Integer isStick) {
		this.isStick = isStick;
	}

	public Integer getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Integer isDraft) {
		this.isDraft = isDraft;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", categoryId=" + categoryId +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", intro='" + intro + '\'' +
				", content='" + content + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				", sortNo=" + sortNo +
				", allowComment=" + allowComment +
				", isStick=" + isStick +
				", isDraft=" + isDraft +
				", isDeleted=" + isDeleted +
				'}';
	}
}
