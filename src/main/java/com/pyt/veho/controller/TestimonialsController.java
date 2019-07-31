package com.pyt.veho.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.veho.model.Testimonial;
import com.pyt.veho.service.TestimonialService;

@RestController
public class TestimonialsController {
	private final String BASE_URL = "/testimonials";
	private final String GET_SINGLE_TESTIMONIAL = BASE_URL + "/{id}";
	private final String EDIT_TESTIMONIAL = BASE_URL + "/{id}";
	private final String DELETE_TESTIMONIAL = BASE_URL + "/{id}";
	@Autowired
	private TestimonialService testimonialService;
	
	@GetMapping(BASE_URL)
	public List<Testimonial> getTestimonials(){
		return testimonialService.getTestimonials();
	}
	
	/*
	@GetMapping(GET_SINGLE_TESTIMONIAL)
	public Testimonial getTestimonial(@PathVariable int id) {
		return testimonialService.getTestimonial(id);
	}
	*/
	
	@PostMapping(BASE_URL)
	public void newTestimonial(@RequestBody Testimonial testimonial) {
		testimonialService.newTestimonial(testimonial);
	}
	
	/*
	@PutMapping(EDIT_TESTIMONIAL)
	public void editTestimonial(@RequestBody Testimonial testimonial,@PathVariable int id) {
		testimonialService.editTestimonial(testimonial, id);
	}
	@DeleteMapping(DELETE_TESTIMONIAL)
	public void deleteTestimonial(@PathVariable int id) {
		testimonialService.deleteTestimonial(id);
	}
	*/

}
