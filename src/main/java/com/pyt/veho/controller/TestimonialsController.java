package com.pyt.veho.controller;


import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.model.Testimonial;
import com.pyt.veho.service.TestimonialService;
import com.pyt.veho.vo.TestimonialFilterVO;

@RestController
@RequestMapping("/testimonials")
public class TestimonialsController {
	private static final Logger logger = LoggerFactory.getLogger(TestimonialsController.class);
	private GenericResponse genericResponse = new GenericResponse();
	
	@Autowired
	private TestimonialService testimonialService;
	
	@GetMapping()
	public List<Testimonial> getTestimonials(){
		return testimonialService.getTestimonials();
	}
	
	
	@GetMapping("/{id}")
	public GenericResponse getTestimonial(@PathVariable String id) {
		return new GenericResponse(testimonialService.getTestimonialById(id));
	}
	
	
	@PostMapping()
	@ResponseBody
	public GenericResponse saveTestimonial(@RequestBody @Valid Testimonial testimonial) {
		testimonialService.saveTestimonial(testimonial);
		genericResponse.setMessage("Testimonial saved successfully");
		return genericResponse;
		
	}
	
	
	
	@PutMapping("/{id}")
	@ResponseBody
	public GenericResponse editTestimonial(@RequestBody Map<String, String> testimonial,@PathVariable String id) {
		 testimonialService.editTestimonial(testimonial, id);
		 genericResponse.setMessage("Testimonial updated successfully");
		 return genericResponse;
		 
	}

	@GetMapping("/results")
	public List<Testimonial> paginatedTestimonials(@RequestParam("page") int pageNumber,@RequestParam("size") int pageSize){
		return testimonialService.paginatedTestimonials(pageNumber, pageSize);
	}
	
	@PostMapping("/filter")
	public List<Testimonial> getTestimonialByParam(@RequestBody TestimonialFilterVO testimonialFilterVO){
	    return testimonialService.getTestimonialByParam(testimonialFilterVO);
	}
	
	@PostMapping("/sort")
	public List<Testimonial> getSortedTestimonials(@RequestParam("offset") int pageNumber,@RequestParam("limit") int pageSize,@RequestBody TestimonialFilterVO testimonialFilterVO,@RequestParam("sortby") String sortBy){
		return testimonialService.getSortedTestimonials(testimonialFilterVO, pageNumber, pageSize, sortBy);
	}
	
	@DeleteMapping("/{id}")
	public GenericResponse deleteTestimonial(@PathVariable String id) {
		testimonialService.deleteTestimonialById(id);
		genericResponse.setMessage("Testimonial Deleted successfully");
		return genericResponse;
	}

/*	
	@PatchMapping("/{id}")
	public void editTestimonialFeilds(@RequestBody Map<String , String> testimonial,@PathVariable String id) {
		testimonialService.editTestimonial(testimonial, id);
	}
*/
	
}
