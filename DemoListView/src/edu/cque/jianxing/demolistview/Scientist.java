package edu.cque.jianxing.demolistview;

import java.io.Serializable;

public class Scientist implements Serializable {
	
	private String name;
	private int imageId;
	private int iconId;
	private String deed;
	private String birthday;
	private String nationality;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getIconId() {
		return iconId;
	}
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	public String getDeed() {
		return deed;
	}
	public void setDeed(String deed) {
		this.deed = deed;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

	
}
