package org.bigjava.bean;

import java.util.*;

public class News {
	private int id;
	private String newsName;
	private String author;
	private String title;
	private String content;
	private Date createTime;
	private Date modifyTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", newsName=" + newsName + ", author=" + author + ", title=" + title + ", content="
				+ content + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
	public News(int id, String newsName, String author, String title, String content, Date createTime,
			Date modifyTime) {
		super();
		this.id = id;
		this.newsName = newsName;
		this.author = author;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}
	public News() {
		
	}
	
	
}
