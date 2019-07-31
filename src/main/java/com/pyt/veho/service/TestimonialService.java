package com.pyt.veho.service;

import com.pyt.veho.controller.*;
import com.pyt.veho.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.pyt.veho.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonialService {
	
	@Autowired
	private TestimonialDAO testimonialDAO;
	
	
	private List<Testimonial> testimonial = new ArrayList<>(Arrays.asList(
			new Testimonial("1","Sayee","Saran","Chennai","Dubai"),
			new Testimonial("2","Sai","Sanjay","Chennai","Dubai"),
			new Testimonial("3","Gowtham","S","Chennai","Dubai"),
			new Testimonial("4","Kuzhali","S","Chennai","Dubai")
			));
	
	public List<Testimonial> getTestimonials(){
		return testimonialDAO.getTestimonial();
	}
	
	
	 
	 
	public Testimonial getTestimonial(String id) {
		return testimonial.stream().filter(t -> t.getItineraryId().equals(id)).findFirst().get();
	}
	
	

	public void addTestimonial(Testimonial newtestimonial) {
		// TODO Auto-generated method stub
		testimonialDAO.createTestimonial(newtestimonial);
		
	}
	
	/*
	 
	 

	public void updateTestimonial(Testimonial updatetestimonial, String id) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<testimonial.size();i++ ) {
			Testimonial t = testimonial.get(i);
			if(t.getItineraryId().equals(id)) {
				testimonial.set(i, updatetestimonial);
				return;
			}
		}
		
	}

	public void deleteTestimonial(String id) {
		// TODO Auto-generated method stub
		testimonial.removeIf(t -> t.getItineraryId().equals(id));
		
	}
	*/
}
