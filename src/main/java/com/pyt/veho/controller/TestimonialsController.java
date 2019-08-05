package com.pyt.veho.controller;


import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.model.Testimonial;
import com.pyt.veho.service.TestimonialService;
import com.pyt.veho.vo.TestimonialFilterVO;

@RestController
public class TestimonialsController {
	private final String BASE_URL = "/testimonials";
	private final String GET_SINGLE_TESTIMONIAL = BASE_URL + "/{id}";
	private final String EDIT_TESTIMONIAL = BASE_URL + "/{id}";
	private final String DELETE_TESTIMONIAL = BASE_URL + "/{id}";
	private final String PAGING_URL = BASE_URL+"/results";
	private final String FILTER_URL = BASE_URL + "/filter";
	@Autowired
	private TestimonialService testimonialService;
	
	@GetMapping(BASE_URL)
	public List<Testimonial> getTestimonials(){
		return testimonialService.getTestimonials();
	}
	
	
	@GetMapping(GET_SINGLE_TESTIMONIAL)
	public Testimonial getTestimonial(@PathVariable String id) {
		return testimonialService.getTestimonialById(id);
	}
	
	
	@PostMapping(BASE_URL)
	public void saveTestimonial(@RequestBody Testimonial testimonial) {
		testimonialService.saveTestimonial(testimonial);
	}
	
	
	/*
	@PutMapping(EDIT_TESTIMONIAL)
	public void editTestimonial(@RequestBody Testimonial testimonial,@PathVariable String id) {
		testimonialService.editTestimonial(testimonial, id);
	}
	*/
	@PatchMapping(EDIT_TESTIMONIAL)
	public void editTestimonialFeilds(@RequestBody Map<String , String> testimonial,@PathVariable String id) {
		testimonialService.editTestimonial(testimonial, id);
	}
	
	//@GetMapping(BASE_URL+"/{pageNumber}/{pageSize}")
	@GetMapping(PAGING_URL)
	public List<Testimonial> paginatedTestimonials(@RequestParam("page") int pageNumber,@RequestParam("size") int pageSize){
		return testimonialService.paginatedTestimonials(pageNumber, pageSize);
	}
	
	@RequestMapping(value = FILTER_URL , method = RequestMethod.POST)
	public List<Testimonial> getTestimonialByParam(@RequestBody TestimonialFilterVO testimonialFilterVO){
	    return testimonialService.getTestimonialByParam(testimonialFilterVO);
	}
	
	@DeleteMapping(DELETE_TESTIMONIAL)
	public void deleteTestimonial(@PathVariable String id) {
		testimonialService.deleteTestimonialById(id);
	}


}
