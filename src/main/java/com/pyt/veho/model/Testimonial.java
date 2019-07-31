package com.pyt.veho.model;

public class Testimonial {
	
	private String itineraryId;
	private String fname;
	private String mname;
	private String dep_city;
	private String arr_city;
	
	public Testimonial(){
		
	}
	
	public String getArr_city() {
		return arr_city;
	}

	public void setArr_city(String arr_city) {
		this.arr_city = arr_city;
	}

	public Testimonial(String itineraryId, String fname, String mname, String dep_city, String arr_city) {
		super();
		this.itineraryId = itineraryId;
		this.fname = fname;
		this.mname = mname;
		this.dep_city = dep_city;
		this.arr_city = arr_city;
	}
	public String getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDep_city() {
		return dep_city;
	}
	public void setDep_city(String dep_city) {
		this.dep_city = dep_city;
	}

}
