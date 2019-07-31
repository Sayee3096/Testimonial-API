package com.pyt.veho.model;


import java.util.*;


public class Testimonial {
	private int testimonialId;
	private String itineraryId;
	private String firstName;
	private String middleName;
	private String lastName;
	private List<String> testimonialPhotos;
	
	public Testimonial() {
	}
	
	public Testimonial(int testimonialId, String itineraryId, String firstName, String middleName, String lastName,
			List<String> testimonialPhotos) {
		super();
		this.testimonialId = testimonialId;
		this.itineraryId = itineraryId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.testimonialPhotos = testimonialPhotos;
	}
	public int getTestimonialId() {
		return testimonialId;
	}
	public void setTestimonialId(int testimonialId) {
		this.testimonialId = testimonialId;
	}
	public String getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getTestimonialPhotos() {
		return testimonialPhotos;
	}
	public void setTestimonialPhotos(List<String> testimonialPhotos) {
		this.testimonialPhotos = testimonialPhotos;
	}

	@Override
	public String toString() {
		return "Testimonial [testimonialId=" + testimonialId + ", itineraryId=" + itineraryId + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", testimonialPhotos="
				+ testimonialPhotos + "]";
	}
	

}

