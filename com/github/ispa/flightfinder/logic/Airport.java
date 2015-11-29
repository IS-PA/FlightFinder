package com.github.ispa.flightfinder.logic;

public class Airport {
	private int id;
	private String country;
	private String displayname;
	
	public Airport(int id, String country, String displayname) {
		this.id = id;
		this.country = country;
		this.displayname = displayname;
	}

	public int getId() {
		return this.id;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}
	
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getDisplayname() {
		return this.displayname;
	}
}
