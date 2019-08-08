package com.pyt.veho.dao;


/*
 * FileName: TestimonialDAO.java
 * 
 * Functionality: This class is the DAO layer for the SpringBoot Application developed. All the interactions
 * and operation with MongoDB are perfomed in the functions implemented in this class.
 * 
 */
import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.constants.GenericResponseStatus;
import com.pyt.veho.controller.TestimonialsController;
import com.pyt.veho.model.Testimonial;
import com.pyt.veho.vo.TestimonialFilterVO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class TestimonialDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestimonialsController.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	/*
	* Function Name: getTestimonials()
	* 
	* Functionality: This function retrives all the testimonials from the MongoDB and is returned to
	* the Service layer.
	*/
	public List<Testimonial> getTestimonial(){
		return mongoTemplate.findAll(Testimonial.class);
	}
	
	/*
	* Function Name: saveTestimonial()
	* 
	* Functionality: This function saves a new testimonial to the MongoDB after receiving the Request
	* Body from the Service layer.
	*/
	public void saveTestimonial(Testimonial newtestimonial) {
		mongoTemplate.insert(newtestimonial);
		LOGGER.info("POST : "+"New Testimonial Saved successfully");
	}
	
	/*
	* Function Name: getTestimonialById()
	* 
	* Functionality: This function retrieves a particular testimonial from the MongoDB according to
	* the testimonial_id given by the User.
	*/
	public Testimonial getTestimonialById(String id) {
		Query query = new Query(Criteria.where("testimonialId").exists(true));
		if(!mongoTemplate.exists(query,Testimonial.class)) {
			LOGGER.info("GET : "+"No record found for the given id ");
		}
		return mongoTemplate.findById(id, Testimonial.class);
	}
	
	/*
	* Function Name: editTestimonial()
	* 
	* Functionality: This function updates a particular Testimonial with the new parameters as given 
	* by the user in the Request Body.
	*/
	public boolean editTestimonial(Map<String, String> testimonial, String id) {
		Query query = new Query(Criteria.where("testimonialId").is(id));
        List<Testimonial> t = mongoTemplate.find(query, Testimonial.class);
		if(!t.isEmpty()){
			LOGGER.info("PUT : "+ "Testimonial record found for given id");
		testimonial.forEach((key,value)->{
 
            Update update = new Update();
            update.set(key,value);
            mongoTemplate.findAndModify(query, update, Testimonial.class);
            
        });
			LOGGER.info("PUT : " + "Testimonial updated succesfuully");
			return true;
		}
		else {
			LOGGER.info("PUT : " + "Testimonial record not found");
			return false;
		}
	}
	
	/*
	* Function Name: deleteTestimonialById()
	* 
	* Functionality: This function deletes a particular Testimonial according to the testimonial_id
	* given by the user.
	*/
	public void deleteTestimonialById(String id) {
        Query query = new Query(Criteria.where("testimonialId").is(id));
        mongoTemplate.remove(query, Testimonial.class);
        LOGGER.info("DELETE : " + "Testimonial record deleted successfully");
    }
	
	/*
	* Function Name: getSortedtestmonials()
	* 
	* Functionality: This function performs the Pagination, Sorting and Filtering of the data and then
	* returns the data to the user.
	* 
	*/
	public List<Testimonial> getSortedTestimonials(TestimonialFilterVO testimonialFilterVO,int pageNumber, int pageSize, String sortBy) {
		Query query = new Query();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		 if (testimonialFilterVO != null) {
	            if (testimonialFilterVO.getRegion() != null) {
	            	LOGGER.info("POST : " + "Testimonial record not found ");
	                query.addCriteria(Criteria.where("region").in(testimonialFilterVO.getRegion()));
	            }
	            if (testimonialFilterVO.getTripType() != null) {
	            	query.addCriteria(Criteria.where("T_Type").in(testimonialFilterVO.getTripType()));
	            }
	            if (testimonialFilterVO.getDepartureCity() != null) {
	                query.addCriteria(Criteria.where("DEP_CITY").in(testimonialFilterVO.getDepartureCity()));
	            }
	            if (testimonialFilterVO.getDateOfDeparture() != null) {
	                query.addCriteria(Criteria.where("DEP_DATE").in(testimonialFilterVO.getDateOfDeparture()));
	            }
	            if (testimonialFilterVO.getStar() != null) {
	                query.addCriteria(Criteria.where("star").in(testimonialFilterVO.getStar()));
	            }
	            if (testimonialFilterVO.getDestination() != null) {
	                query.addCriteria(Criteria.where("destination").in(testimonialFilterVO.getDestination()));
	            }
	        }
		 
		query.with(pageable);

        return mongoTemplate.find(query, Testimonial.class);
	}

	
}



/*
 * 
 *
 * public List<Testimonial> paginatedTestimonials(int pageNumber,int pageSize,Pageable page) {
		Query query = new Query().with(page);
		return mongoTemplate.find(query,Testimonial.class);
	}
	
	public List<Testimonial> getFilteredTestimonial(TestimonialFilterVO testimonialFilterVO) {
        Query query = new Query();    
        if (testimonialFilterVO != null) {
            if (testimonialFilterVO.getRegion() != null) {
                query.addCriteria(Criteria.where("region").in(testimonialFilterVO.getRegion()));
            }
            if (testimonialFilterVO.getTripType() != null) {
            	query.addCriteria(Criteria.where("T_Type").in(testimonialFilterVO.getTripType()));
            }
            if (testimonialFilterVO.getDepartureCity() != null) {
                query.addCriteria(Criteria.where("DEP_CITY").in(testimonialFilterVO.getDepartureCity()));
            }
            if (testimonialFilterVO.getDateOfDeparture() != null) {
                query.addCriteria(Criteria.where("DEP_DATE").in(testimonialFilterVO.getDateOfDeparture()));
            }
            if (testimonialFilterVO.getStar() != null) {
                query.addCriteria(Criteria.where("star").in(testimonialFilterVO.getStar()));
            }
            if (testimonialFilterVO.getDestination() != null) {
                query.addCriteria(Criteria.where("destination").in(testimonialFilterVO.getDestination()));
            }
        }
        return mongoTemplate.find(query, Testimonial.class);
    }
*/