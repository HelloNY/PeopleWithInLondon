package com.dwp.area;

import com.google.gson.annotations.SerializedName;

public class Person {
	
	private long id;
	@SerializedName("first_name")
	private String firstName;
	@SerializedName("last_name")
	private String lastName;
	private String email;
	private String city;
	@SerializedName("ip_address")
	private String ipAddress;
	private double latitude;
	private double longitude;
	
	
	Person (long id, String firstName, String lastName, String email, String city, 
			String ipAddress, double latitude, double longitude){
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setCity(city);
		setIpAddess(ipAddress);
		setLongitude(longitude);
		setLongitude(longitude);
		
		
		
	}
	public long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	protected void setCity(String city) {
		this.city = city;
	}
	public String getIpAddess() {
		return ipAddress;
	}
	protected void setIpAddess(String ipAddess) {
		this.ipAddress = ipAddess;
	}
	public double getLatitude() {
		return latitude;
	}
	protected void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	protected void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Person[ id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ ", email=" + getEmail() + ", city=" + getCity() + ", ipAddess=" + getIpAddess()
				+ ", latitude=" + getLatitude() + ", longitude=" + getLongitude() + "]";
	}
	
	
	

}
