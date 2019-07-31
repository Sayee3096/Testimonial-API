package com.pyt.veho.controller;

import com.pyt.veho.service.*;
import com.pyt.veho.model.*;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestimonialsController {
	private final String BASE_URL = "/testimonials";
	private final String GET_SINGLE_TESTIMONIAL = BASE_URL + "/{id}";
	private final String EDIT_TESTIMONIAL = BASE_URL + "/{id}";
	private final String DELETE_TESTIMONIAL = BASE_URL + "/{id}";
	
	@Autowired
	private TestimonialsService testService;
	
	@GetMapping("/testimonial")
	public List<Testimonial> getTestimonials(){
		
		return testService.getTestimonials();
	}
	
	/*
	@RequestMapping("/testimonial/{id}")
	public Testimonial getTestimonial(@PathVariable String id) {
		return testService.getTestimonial(id);
	}
	*/
	
	@PostMapping(value="/testimonial")
	public void addTestimonial(@RequestBody Testimonial testimonial) {
		
		testService.addTestimonial(testimonial);
		
	}
	
	/*
	 
	 
	@RequestMapping(method=RequestMethod.PUT, value="/testimonial/{id}")
	public void updateTestimonial(@RequestBody Testimonial testimonial, @PathVariable String id) {
		
		testService.updateTestimonial(testimonial,id);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/testimonial/{id}")
	public void deleteTestimonial(@PathVariable String id) {
		
		testService.deleteTestimonial(id);
		
	}
*/
}
