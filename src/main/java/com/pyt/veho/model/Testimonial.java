package com.pyt.veho.model;


import java.util.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.pyt.veho.constants.TripType;
@Document(collection = "Testimonial")
public class Testimonial {
    
    @Id
    private String testimonialId;
    
    @NotEmpty(message="Provide itineraryId")
    private String itineraryId;
    
    @NotEmpty(message="Provide firstName")
    private String firstName;
    
    private String middleName;
    private String lastName;
    
    @NotNull(message="Provide DEP_DATE")
    @Field("DEP_DATE")
    private long dateOfDeparture;
    
    @NotBlank(message="Provide DEP_CITY")
    @Field("DEP_CITY")
    private String departureCity;
    
    @NotNull(message="Provide Star")
    private float star;
    
    private long timeOfReview;
    private String shortReview;
    private String shortestReview;
    private String longReview;
    
    @NotBlank(message="Provide review")
    private String review;
    
    
    private String facebookLink;
    private String profileImage;
    private String coverImage;
    
    @NotBlank(message="Provide region")
    private String region;
    
    @NotBlank(message="Provide dest")
    @Field("Dest")
    private String destination;
    
    @NotNull(message="Provide T_Type")
    @Field("T_Type")
    private TripType tripType;
    
    
    private boolean pdf;
    
    @Field("soemail")
    private String salesOwnerEmail;
    
    @Field("jrnllnks")
    private List<String> journalLinks;
    
    @Field("tstmlptos")
    private List<String> testimonialPhotos;
    
    private boolean isSOTagged;
    private int coverImageWidth;
    private int coverImageHeight;
    private boolean centreFaceCroppedCoverImage;
    
    public Testimonial(){
        
    }
    
    public Testimonial(String testimonialId, String itineraryId, String firstName, String middleName, String lastName,
            long dateOfDeparture, String departureCity, float star, long timeOfReview, String shortReview,
            String shortestReview, String longReview, String review, String facebookLink, String profileImage,
            String coverImage, String region, String destination, TripType tripType, boolean pdf,
            String salesOwnerEmail, List<String> journalLinks, List<String> testimonialPhotos, boolean isSOTagged,
            int coverImageWidth, int coverImageHeight, boolean centreFaceCroppedCoverImage) {
        super();
        this.testimonialId = testimonialId;
        this.itineraryId = itineraryId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfDeparture = dateOfDeparture;
        this.departureCity = departureCity;
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
        this.tripType = tripType;
        this.pdf = pdf;
        this.salesOwnerEmail = salesOwnerEmail;
        this.journalLinks = journalLinks;
        this.testimonialPhotos = testimonialPhotos;
        this.isSOTagged = isSOTagged;
        this.coverImageWidth = coverImageWidth;
        this.coverImageHeight = coverImageHeight;
        this.centreFaceCroppedCoverImage = centreFaceCroppedCoverImage;
    }
    public TripType getTripType() {
        return tripType;
    }
    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }
    public String getTestimonialId() {
        return testimonialId;
    }
    public void setTestimonialId(String testimonialId) {
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
    public long getDateOfDeparture() {
        return dateOfDeparture;
    }
    public void setDateOfDeparture(long dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
    public String getDepartureCity() {
        return departureCity;
    }
    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }
    public float getStar() {
        return star;
    }
    public void setStar(float star) {
        this.star = star;
    }
    public long getTimeOfReview() {
        return timeOfReview;
    }
    public void setTimeOfReview(long timeOfReview) {
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
    public TripType getTriptype() {
        return tripType;
    }
    public void setTriptype(TripType tripType) {
        this.tripType = tripType;
    }
    public boolean isPdf() {
        return pdf;
    }
    public void setPdf(boolean pdf) {
        this.pdf = pdf;
    }
    public String getSalesOwnerEmail() {
        return salesOwnerEmail;
    }
    public void setSalesOwnerEmail(String salesOwnerEmail) {
        this.salesOwnerEmail = salesOwnerEmail;
    }
    public List<String> getJournalLinks() {
        return journalLinks;
    }
    public void setJournalLinks(List<String> journalLinks) {
        this.journalLinks = journalLinks;
    }
    public List<String> getTestimonialPhotos() {
        return testimonialPhotos;
    }
    public void setTestimonialPhotos(List<String> testimonialPhotos) {
        this.testimonialPhotos = testimonialPhotos;
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
    public boolean isCentreFaceCroppedCoverImage() {
        return centreFaceCroppedCoverImage;
    }
    public void setCentreFaceCroppedCoverImage(boolean centreFaceCroppedCoverImage) {
        this.centreFaceCroppedCoverImage = centreFaceCroppedCoverImage;
    }
        
}

