package com.pyt.veho.service;

/*
 * FileName: TestimonialService.java
 * 
 * Functionality: This class is the Service layer for the SpringBoot application developed. All the
 * operations other than the Database operations are done in the class. Each function will call the 
 * respective function in the DAO layer.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pyt.veho.model.Testimonial;
import com.pyt.veho.vo.TestimonialFilterVO;
import com.pyt.veho.dao.*;
import com.pyt.veho.constants.ConstantFunctions;
import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.constants.GenericResponseStatus;
@Service
public class TestimonialService {
	
	@Autowired
	private TestimonialDAO testimonialDao;

	/*
	* Function Name: getTestimonials()
	* 
	* Functionality: This function calls the getTestimonial function in the DAO layer which returns
	* all the testimonials from MongoDB.
	*/
	public List<Testimonial> getTestimonials(){
		return testimonialDao.getTestimonial();
	}
	
	/*
	* Function Name: getTestimonialById()
	* 
	* Functionality: This function calls the getTestimonialById function in the DAO layer which returns
	* the testimonial which corresponds to the respective testimonial_id from MongoDB.
	*/
	public Testimonial getTestimonialById(String id) {
		return testimonialDao.getTestimonialById(id);
	}
	
	/*
	* Function Name: saveTestimonial()
	* 
	* Functionality: This function calls the saveTestimonial function in the DAO layer which saves a 
	* new testimonial to the Database. The UUID is generated and added to the Testimonial Request Body
	* in this function.
	*/
	public void saveTestimonial(Testimonial testimonial) {
		String testimonialId = ConstantFunctions.GenerateUUID();
		testimonial.setTestimonialId(testimonialId);
		testimonialDao.saveTestimonial(testimonial);
	}
	
	/*
	* Function Name: editTestimonial()
	* 
	* Functionality: This function calls the editTestimonial function in the DAO layer updates the 
	* existing testimonial with the updated parameters given by the user in the Request Body.
	*/
	public void editTestimonial(Map<String , String>  testimonial,String id) {
			testimonialDao.editTestimonial(testimonial, id);
	}
	
	/*
	* Function Name: getSortedTestimonial()
	* 
	* Functionality: This function calls the getSortedTestimonials from the DAO layer which performs
	* the Pagination, Filtering and Sorting of the testimonials as requested by the User.
	*/   
	public List<Testimonial> getSortedTestimonials(TestimonialFilterVO testimonialFilterVO,int pageNumber,int pageSize, String sortBy) {
		return testimonialDao.getSortedTestimonials(testimonialFilterVO,pageNumber,pageSize,sortBy);
	}
	
	/*
	* Function Name: deleteTestimonialById()
	* 
	* Functionality: This function calls the deleteTestimonialById function in the DAO layer which 
	* deletes the testimonial which corresponds to the respective testimonial_id from MongoDB.
	*/
	public void deleteTestimonialById(String id) {
        testimonialDao.deleteTestimonialById(id);
        
    }
	

    
    
}







/*
 * public List<Testimonial> paginatedTestimonials(int pageNumber,int pageSize){
	return testimonialDao.paginatedTestimonials(pageNumber, pageSize,new PageRequest(pageNumber,pageSize));
}


public List<Testimonial> getTestimonialByParam(TestimonialFilterVO testimonialFilterVO) {
        
        return testimonialDao.getFilteredTestimonial(testimonialFilterVO);
}
 */
