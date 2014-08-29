package com.parth.bliss.menumanager;

import java.util.ArrayList;

public class DishGroup {
	private String name;
	private ArrayList<DishModel> dishes;
	private String objectID;

	public DishGroup(String objectID, String name) {
		this.name = name;
		this.objectID = objectID;
		dishes = new ArrayList<DishModel>();
	}

	public DishGroup(String name, ArrayList<DishModel> dishes) {
		this.name = name;
		this.dishes = dishes;
	}

	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DishModel> dishes() {
		return dishes;
	}
}
