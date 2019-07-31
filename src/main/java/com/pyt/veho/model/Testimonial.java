package com.pyt.veho.model;


import java.util.*;


public class Testimonial {
	
	
	private int testimonialId;
	private String itineraryId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String DEP_DATE;
	private String DEP_CITY;
	private String star;
	private String timeOfReview;
	private String shortReview;
	private String shortestReview;
	private String longReview;
	private String review;
	private String facebookLink;
	private String profileImage;
	private String coverImage;
	private String region;
	private String destination;
	private String ttype;
	private boolean pdf =false;
	private String soemail;
	private List<String> journalLinks;
	private List<String> testimonialPhotos;
	private boolean isSOTagged;
	private int coverImageWidth;
	private int coverImageHeight;
	private boolean centreFaceCroppedCoverImage;
	
	
	public Testimonial() {
	}
	
	public Testimonial(int testimonialId, String itineraryId, String firstName, String middleName, String lastName,
			String dEP_DATE, String dEP_CITY, String star, String timeOfReview, String shortReview,
			String shortestReview, String longReview, String review, String facebookLink, String profileImage,
			String coverImage, String region, String destination, String ttype, boolean pdf, String soemail,
			List<String> journalLinks, List<String> testimonialPhotos, boolean isSOTagged, int coverImageWidth,
			int coverImageHeight, boolean centreFaceCroppedCoverImage) {
		super();
		this.testimonialId = testimonialId;
		this.itineraryId = itineraryId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		DEP_DATE = dEP_DATE;
		DEP_CITY = dEP_CITY;
		this.star = star;
		this.timeOfReview = timeOfReview;
		this.shortReview = shortReview;
		this.shortestReview = shortestReview;
		this.longReview = longReview;
		this.review = review;
		this.facebookLink = facebookLink;
		this.profileImage = profileImage;
		this.coverImage = coverImage;
		this.region = region;
		this.destination = destination;
		this.ttype = ttype;
		this.pdf = pdf;
		this.soemail = soemail;
		this.journalLinks = journalLinks;
		this.testimonialPhotos = testimonialPhotos;
		this.isSOTagged = isSOTagged;
		this.coverImageWidth = coverImageWidth;
		this.coverImageHeight = coverImageHeight;
		this.centreFaceCroppedCoverImage = centreFaceCroppedCoverImage;
	}

	public String getDEP_DATE() {
		return DEP_DATE;
	}

	public void setDEP_DATE(String dEP_DATE) {
		DEP_DATE = dEP_DATE;
	}

	public String getDEP_CITY() {
		return DEP_CITY;
	}

	public void setDEP_CITY(String dEP_CITY) {
		DEP_CITY = dEP_CITY;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getTimeOfReview() {
		return timeOfReview;
	}

	public void setTimeOfReview(String timeOfReview) {
		this.timeOfReview = timeOfReview;
	}

	public String getShortReview() {
		return shortReview;
	}

	public void setShortReview(String shortReview) {
		this.shortReview = shortReview;
	}

	public String getShortestReview() {
		return shortestReview;
	}

	public void setShortestReview(String shortestReview) {
		this.shortestReview = shortestReview;
	}

	public String getLongReview() {
		return longReview;
	}

	public void setLongReview(String longReview) {
		this.longReview = longReview;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public boolean isPdf() {
		return pdf;
	}

	public void setPdf(boolean pdf) {
		this.pdf = pdf;
	}

	public String getSoemail() {
		return soemail;
	}

	public void setSoemail(String soemail) {
		this.soemail = soemail;
	}

	public List<String> getJournalLinks() {
		return journalLinks;
	}

	public void setJournalLinks(List<String> journalLinks) {
		this.journalLinks = journalLinks;
	}

	public boolean isSOTagged() {
		return isSOTagged;
	}

	public void setSOTagged(boolean isSOTagged) {
		this.isSOTagged = isSOTagged;
	}

	public int getCoverImageWidth() {
		return coverImageWidth;
	}

	public void setCoverImageWidth(int coverImageWidth) {
		this.coverImageWidth = coverImageWidth;
	}

	public int getCoverImageHeight() {
		return coverImageHeight;
	}

	public void setCoverImageHeight(int coverImageHeight) {
		this.coverImageHeight = coverImageHeight;
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