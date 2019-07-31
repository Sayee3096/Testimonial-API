package com.pyt.veho.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyt.veho.model.Testimonial;
import com.pyt.veho.dao.*;

@Service
public class TestimonialService {
	
	@Autowired
	private TestimonialDAO testimonialDao;
	
	public List<Testimonial> getTestimonials(){
		return testimonialDao.getTestimonial();
	}
	
	/*
	public Testimonial getTestimonial(int id) {
		Testimonial testimonial = testimonials.stream().filter(t -> t.getTestimonialId() == id).findAny().orElse(null);
		return testimonial;
	}
	*/
	
	public void newTestimonial(Testimonial testimonial) {
		testimonialDao.createTestimonial(testimonial);
	}
	
	/*
	public void editTestimonial(Testimonial testimonial,int id) {
		for(Testimonial t : testimonials) {
			if(t.getTestimonialId() == id) {
				testimonials.set(testimonials.indexOf(t), testimonial);
			}
		}
	}
	 public void deleteTestimonial(int id) {
		 testimonials.removeIf(t -> t.getTestimonialId() == id);
	 }
	 */
}
