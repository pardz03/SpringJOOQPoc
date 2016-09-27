package com.poc.model;

public class FullImageDetails {
	private int imageId;
	private int imageDetailsId;
	private String name;
	private String path;
	private String comment;
	
	public FullImageDetails(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getImageDetailsId() {
		return imageDetailsId;
	}

	public void setImageDetailsId(int imageDetailsId) {
		this.imageDetailsId = imageDetailsId;
	}
}
