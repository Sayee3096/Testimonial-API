package com.pyt.veho.service;


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
import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.dao.*;
import com.pyt.veho.constants.*;
@Service
public class TestimonialService {
	
	@Autowired
	private TestimonialDAO testimonialDao;
	
	public List<Testimonial> getTestimonials(){
		return testimonialDao.getTestimonial();
	}
	
	public Testimonial getTestimonialById(String id) {
		return testimonialDao.getTestimonialById(id);
	}
	/*
	public Testimonial getTestimonial(int id) {
		Testimonial testimonial = testimonials.stream().filter(t -> t.getTestimonialId() == id).findAny().orElse(null);
		return testimonial;
	}
	*/
	
	public void saveTestimonial(Testimonial testimonial) {
		String testimonialId = ConstantFunctions.GenerateUUID();
		testimonial.setTestimonialId(testimonialId);
		testimonialDao.saveTestimonial(testimonial);
	}
	
	
	/*public void editTestimonial(Testimonial testimonial,String id) {
		testimonialDao.editTestimonial(testimonial, id);
	}
	*/
	public void editTestimonial(Map<String , String>  testimonial,String id) {
		
		testimonialDao.editTestimonial(testimonial, id);
	}
	
	public List<Testimonial> paginatedTestimonials(int pageNumber,int pageSize){
		return testimonialDao.paginatedTestimonials(pageNumber, pageSize,new PageRequest(pageNumber,pageSize));
	}
	
	
	public List<Testimonial> getTestimonialByParam(TestimonialFilterVO testimonialFilterVO) {
	        
	        return testimonialDao.getFilteredTestimonial(testimonialFilterVO);
	}
    public void deleteTestimonialById(String id) {
        testimonialDao.deleteTestimonialById(id);
        
    }
	/*
	 public void deleteTestimonial(int id) {
		 testimonials.removeIf(t -> t.getTestimonialId() == id);
	 }
	 */
}
