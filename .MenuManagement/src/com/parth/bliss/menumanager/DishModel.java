package com.parth.bliss.menumanager;

public class DishModel {
	private String title;
	private String description;
	private String price;
	private String objectID;
	
	public DishModel(String objectID, String title, String description, String price) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.objectID = objectID;
	}

	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
