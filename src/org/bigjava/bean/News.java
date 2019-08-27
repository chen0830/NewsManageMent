package org.bigjava.bean;

import java.util.*;

/**
 * ÏêÏ¸ÐÂÎÅ
 * @author Administrator
 *
 */
public class News {
	
	private int id;
	private String title;
	private String content;
	private Date createTime;
	private int fk_topic_id;
	
	private Date modifyTime;
	private String author;
	
	public News() {
		
	}
	public News(String title, String content, int fk_topic_id) {
		super();
		this.title = title;
		this.content = content;
		this.fk_topic_id = fk_topic_id;
	}
	public News(int id, String title, String content, int fk_topic_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.fk_topic_id = fk_topic_id;
	}
	public News(String title, String content, Date createTime, int fk_topic_id) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.fk_topic_id = fk_topic_id;
	}
	public News(int id, String title, String content, Date createTime, int fk_topic_id, Date modifyTime,
			String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.fk_topic_id = fk_topic_id;
		this.modifyTime = modifyTime;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getFk_topic_id() {
		return fk_topic_id;
	}

	public void setFk_topic_id(int fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", fk_topic_id=" + fk_topic_id + ", modifyTime=" + modifyTime + ", author=" + author + "]";
	}
	
	
}
