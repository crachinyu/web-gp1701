package com.mybatis.pojo;

import java.io.Serializable;

public class Blog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private int authorId;
	private String state;
	private Boolean featured;
	private String style;
	
	public Blog(){
		super();
	/*	this.title="魅族";
		this.authorId=5;
		this.state="sfgh";
		this.featured=false;
		this.style="ssfg";*/
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getFeatured() {
		return featured;
	}
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", authorId=" + authorId + ", state=" + state + ", featured="
				+ featured + ", style=" + style + "]\n";
	}
	
}
