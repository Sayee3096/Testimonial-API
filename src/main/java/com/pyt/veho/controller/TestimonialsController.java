package com.pyt.veho.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.constants.GenericResponseStatus;
import com.pyt.veho.model.Testimonial;
import com.pyt.veho.service.TestimonialService;
import com.pyt.veho.vo.TestimonialFilterVO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/testimonials")
public class TestimonialsController {

	@Autowired
	private TestimonialService testimonialService;

	/**
	 * This function is used to map to the GET functionality to fetch all the data
	 * from MongoDB
	 * 
	 * @return All the Testimonials from MongoDB
	 */

	@GetMapping
	public GenericResponse getTestimonials() {
		return new GenericResponse(testimonialService.getTestimonials());
	}

	/**
	 * This function is used to map to the GET functionality to fetch a single
	 * testimonial from MongoDB using the ID provided as Path variable.
	 * 
	 * @param id
	 * @apiNote URL: testimonials/<testimonial_id>
	 * @return Single Testimonial Object
	 */

	@GetMapping("/{id}")
	public GenericResponse getTestimonialById(@PathVariable String id) {
		GenericResponse genericResponse = new GenericResponse();
		Testimonial testimonial = testimonialService.getTestimonialById(id);
		if (testimonial == null) {
			genericResponse.setStatus(GenericResponseStatus.NOT_FOUND.name());
			// 404 => for when everything is okay, but the resource doesn’texist.
			genericResponse.setResponseCode(404);
			genericResponse.setMessage("No testimonials found for the Id");
			genericResponse.setData(null);
		} else {
			genericResponse.setStatus(GenericResponseStatus.SUCCESS.name());
			genericResponse.setMessage("Testimonial found for the given Id");
			genericResponse.setData(testimonial);
		}
		return genericResponse;
	}

	/**
	 * This function is used to map to the POST functionality to save a new
	 * testimonial to the MongoDB. The parameters are passed in the Request Body.
	 * 
	 * @param testimonial Testimonial to be saved in the DB.
	 * @return Status Message for POST Request.
	 */

	@PostMapping
	public GenericResponse saveTestimonial(@RequestBody @Valid Testimonial testimonial) {
		GenericResponse genericResponse = new GenericResponse();
		if (testimonialService.saveTestimonial(testimonial)) {
			genericResponse.setStatus(GenericResponseStatus.SUCCESS.name());
			genericResponse.setMessage("Testimonial saved successfully");
		} else {
			genericResponse.setStatus(GenericResponseStatus.BAD_REQUEST.name());
			// 400 => for when the requested information is incomplete or malformed.
			genericResponse.setResponseCode(400);
			genericResponse.setMessage("Testimonial already exists with the given Id");
		}

		return genericResponse;

	}

	/**
	 * This function is used to map to the PUT functionality to update/edit an
	 * existing testimonial. The testimonial_id is passed as Path Variable and the
	 * parameters to be updated are passed in a Request Body.
	 * 
	 * @param testimonial The Key-Value pairs that needs to be updated/edited.
	 * @param id          The Testimonial to be edited.
	 * @return Status Message in Generic Response.
	 * @apiNote URL: testimonial/<testimonial_id>
	 */

	@PutMapping("/{id}")
	public GenericResponse editTestimonial(@RequestBody Map<String, String> testimonial, @PathVariable String id) {
		GenericResponse genericResponse = new GenericResponse();
		if (testimonialService.editTestimonial(testimonial, id)) {
			genericResponse.setMessage("Testimonial updated successfully");
		} else {
			genericResponse.setStatus(GenericResponseStatus.NOT_FOUND.name());
			// 404 => for when everything is okay, but the resource doesn’texist.
			genericResponse.setResponseCode(404);
			genericResponse.setMessage("No Testimonial record found for given id");
		}

		return genericResponse;

	}

	/**
	 * This function is used for Pagination, Filtering and Sorting functionality.
	 * The Pagination and Sorting parameters are passed as Request Params and the
	 * Filtering parameters are passed as Request Body.
	 * 
	 * @param pageNumber          Offset Parameter
	 * @param pageSize            Limit Parameter
	 * @param testimonialFilterVO The filter params.
	 * @param sortBy              The key in the Testimonial to be sorted.
	 * @return The filtered and sorted testimonials with Pagination.
	 */

	@PostMapping("/sort")
	public List<Testimonial> getSortedTestimonials(@RequestBody TestimonialFilterVO testimonialFilterVO,
			@RequestParam("offset") int offset, @RequestParam("limit") int limit,
			@RequestParam("sortby") String sortBy) {
		return testimonialService.getSortedTestimonials(testimonialFilterVO, offset, limit, sortBy);
	}

	/**
	 * This function is used to map to the DELETE functionality to delete an
	 * existing testimonial from the MongoDB.
	 * 
	 * @param id Testimonial to be deleted.
	 * @return Status message
	 */

	@DeleteMapping("/{id}")
	public GenericResponse deleteTestimonial(@PathVariable String id) {
		GenericResponse genericResponse = new GenericResponse();
		if (testimonialService.deleteTestimonialById(id)) {
			genericResponse.setMessage("Testimonial record deleted successfully");
		} else {
			genericResponse.setStatus(GenericResponseStatus.NOT_FOUND.name());
			// 404 => for when everything is okay, but the resource doesn’texist.
			genericResponse.setResponseCode(404);
			genericResponse.setMessage("No record found for the Id");
		}
		return genericResponse;
	}

	@PostMapping("/search")
	public GenericResponse searchTestimonials(@RequestParam("search_name") String query) {
		GenericResponse genericResponse = new GenericResponse();
		if (query == null || query.equals("")) {
			genericResponse.setStatus(GenericResponseStatus.BAD_REQUEST.name());
			// 400 => for when the requested information is incomplete or malformed.
			genericResponse.setResponseCode(400);
			genericResponse.setMessage("Search Query is empty");
			genericResponse.setData(null);
		} else {
			genericResponse.setMessage("Search Results");
			genericResponse.setData(testimonialService.searchTestimonials(query));
		}
		return genericResponse;
	}
}
