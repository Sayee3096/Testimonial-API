package com.pyt.veho.controller;

/*
 * FileName: TestimonialsController.java
 * 
 * Functionality: This class is the Controller layer for the SpringBoot application developed. All the
 * mapping to the respective urls is done in this class. Each url will correspond to the respective
 * functioniality.
 * 
 * BaseURL: '/testimonials'
 */


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

	/*
	 * Function Name: getTestimonials()
	 * 
	 * Functionality: This function is used to map to the GET functionality to fetch all the 
	 * data from MongoDB
	 * 
	 * URL: '/testimonials'
	 * Request Method: 'GET'
	 */
	@GetMapping()
	public List<Testimonial> getTestimonials(){
		return testimonialService.getTestimonials();
	}
	
	/*
	 * Function Name: getTestimonial()
	 * 
	 * Functionality: This function is used to map to the GET functionality to fetch a single
	 * testimonial from MongoDB using the ID provided as Path variable.
	 * 
	 * URL: '/testimonials/<testimonial_id>'
	 * Request Method: 'GET'
	 */
	@GetMapping("/{id}")
	public GenericResponse getTestimonial(@PathVariable String id) {
		return new GenericResponse(testimonialService.getTestimonialById(id));
	}
	
	/*
	 * Function Name: saveTestimonial()
	 * 
	 * Functionality: This function is used to map to the POST functionality to save a new 
	 * testimonial to the MongoDB. The parameters are passed in the Request Body.
	 * 
	 * URL: '/testimonials'
	 * Request Method: 'POST'
	 */
	@PostMapping()
	@ResponseBody
	public GenericResponse saveTestimonial(@RequestBody @Valid Testimonial testimonial) {
		testimonialService.saveTestimonial(testimonial);
		genericResponse.setMessage("Testimonial saved successfully");
		return genericResponse;
		
	}
	
	
	/*
	 * Function Name: editTestimonial()
	 * 
	 * Functionality: This function is used to map to the PUT functionality to update/edit an existing
	 * testimonial. The testimonial_id is passed as Path Variable and the parameters to be updated are
	 * passed in a Request Body.
	 * 
	 * URL: '/testimonials/<testimonial_id>'
	 * Request Method: 'PUT'
	 */
	@PutMapping("/{id}")
	@ResponseBody
	public GenericResponse editTestimonial(@RequestBody Map<String, String> testimonial,@PathVariable String id) {
		 testimonialService.editTestimonial(testimonial, id);
		 genericResponse.setMessage("Testimonial updated successfully");
		 return genericResponse;
		 
	}

	/*
	 * Function Name: getSortedTestimonials()
	 * 
	 * Functionality: This function is used for Pagination, Filtering and Sorting functionality. The
	 * Pagination and Sorting parameters are passed as Request Params and the Filtering parameters are
	 * passed as Request Body.
	 * 
	 * URL: '/testimonials/sort'
	 * Request Method: 'POST'
	 */
	@PostMapping("/sort")
	public List<Testimonial> getSortedTestimonials(@RequestParam("offset") int pageNumber,@RequestParam("limit") int pageSize,@RequestBody TestimonialFilterVO testimonialFilterVO,@RequestParam("sortby") String sortBy){
		return testimonialService.getSortedTestimonials(testimonialFilterVO, pageNumber, pageSize, sortBy);
	}
	
	
	/*
	 * Function Name: deleteTestimonial()
	 * 
	 * Functionality: This function is used to map to the DELETE functionality to delete an existing 
	 * testimonial from the MongoDB.
	 * 
	 * URL: '/testimonials/<testimonial_id>'
	 * Request Method: 'DELETE'
	 */
	@DeleteMapping("/{id}")
	public GenericResponse deleteTestimonial(@PathVariable String id) {
		testimonialService.deleteTestimonialById(id);
		genericResponse.setMessage("Testimonial Deleted successfully");
		return genericResponse;
	}


	
}








/*	
@PatchMapping("/{id}")
public void editTestimonialFeilds(@RequestBody Map<String , String> testimonial,@PathVariable String id) {
	testimonialService.editTestimonial(testimonial, id);
}

@GetMapping("/results")
public List<Testimonial> paginatedTestimonials(@RequestParam("page") int pageNumber,@RequestParam("size") int pageSize){
	return testimonialService.paginatedTestimonials(pageNumber, pageSize);
}

@PostMapping("/filter")
public List<Testimonial> getTestimonialByParam(@RequestBody TestimonialFilterVO testimonialFilterVO){
    return testimonialService.getTestimonialByParam(testimonialFilterVO);
}
*/
