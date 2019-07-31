package com.pyt.veho.dao;

import com.pyt.veho.model.Testimonial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestimonialDAO {
	
	@Autowired
	private TestimonialRepository repository;
	
	public List<Testimonial> getTestimonial(){
		
		return repository.findAll();
		}

	public Testimonial createTestimonial(Testimonial newtestimonial) {
		// TODO Auto-generated method stub
		return repository.insert(newtestimonial);
		
	}

}
