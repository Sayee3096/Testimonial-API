package com.pyt.veho.vo;

/*
 * FileName: TestimonialFilterVO.java
 * 
 * Functionality: This is the POJO class for the Testimonial filter object created. It follows this specific 
 * template everytime the user wants to filter the MongoDB for testimonials. 
 * 
 */
import com.pyt.veho.constants.TripType;

public class TestimonialFilterVO {
	 	private String dateOfDeparture;
	    private String departureCity;
	    private String region;
	    private String star;
	    private TripType tripType;
	    public TripType getTripType() {
			return tripType;
		}
		public void setTripType(TripType tripType) {
			this.tripType = tripType;
		}
		public String getDateOfDeparture() {
			return dateOfDeparture;
		}
		public void setDateOfDeparture(String dateOfDeparture) {
			this.dateOfDeparture = dateOfDeparture;
		}
		public String getDepartureCity() {
			return departureCity;
		}
		public void setDepartureCity(String departureCity) {
			this.departureCity = departureCity;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getStar() {
			return star;
		}
		public void setStar(String star) {
			this.star = star;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		private String destination;
	    
	    
	   
}
