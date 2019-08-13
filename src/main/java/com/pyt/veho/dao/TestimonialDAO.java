package com.pyt.veho.dao;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

import com.mongodb.client.result.DeleteResult;
import com.pyt.veho.model.Testimonial;
import com.pyt.veho.vo.TestimonialFilterVO;

@Component
public class TestimonialDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(TestimonialDAO.class);

	/**
	 * This function retrives all the testimonials from the MongoDB and is returned
	 * to the Service layer.
	 * 
	 * @return All testimonials from MongoDB.
	 */

	public List<Testimonial> getTestimonial() {
		return mongoTemplate.findAll(Testimonial.class);
	}

	/**
	 * This function saves a new testimonial to the MongoDB after receiving the
	 * Request Body from the Service layer.
	 * 
	 * @param newtestimonial New Testimonial to be saved in DB.
	 */

	public boolean saveTestimonial(Testimonial newTestimonial) {
		Query query = new Query(Criteria.where("testimonialId").is(newTestimonial.getTestimonialId()));
		if (!mongoTemplate.exists(query, Testimonial.class)) {
			mongoTemplate.insert(newTestimonial);
			LOGGER.info("POST : " + "New Testimonial Saved successfully");
			return true;
		} else {
			LOGGER.info("POST : " + "Testimonial already exists");
			return false;
		}
	}

	/**
	 * This function retrieves a particular testimonial from the MongoDB according
	 * to the testimonial_id given by the User.
	 * 
	 * @param id Id of testimonial to be retrieved.
	 * @return Single Testimonial.
	 */

	public Testimonial getTestimonialById(String id) {
		return mongoTemplate.findById(id, Testimonial.class);
	}

	/**
	 * This function updates a particular Testimonial with the new parameters as
	 * given by the user in the Request Body.
	 * 
	 * @param testimonial The params to be updated.
	 * @param id          Id of the testimonial to be edited.
	 * @return Status message.
	 */

	public boolean editTestimonial(Map<String, String> testimonial, String id) {
		Query query = new Query(Criteria.where("testimonialId").is(id));
		List<Testimonial> t = mongoTemplate.find(query, Testimonial.class);
		Update update = new Update();
		if (!t.isEmpty()) {
			LOGGER.info("PUT : " + "Testimonial record found for given id");
			testimonial.forEach((key, value) -> {
				update.set(key, value);
			});
			mongoTemplate.findAndModify(query, update, Testimonial.class);
			LOGGER.info("PUT : " + "Testimonial updated succesfuully");
			return true;
		} else {
			LOGGER.info("PUT : " + "Testimonial record not found");
			return false;
		}
	}

	/**
	 * This function deletes a particular Testimonial according to the
	 * testimonial_id given by the user.
	 * 
	 * @param id Id of the testimonial to be deleted.
	 */

	public boolean deleteTestimonialById(String id) {
		Query query = new Query(Criteria.where("testimonialId").is(id));
		DeleteResult d = mongoTemplate.remove(query, Testimonial.class);
		if (d.getDeletedCount() == 1) {
			LOGGER.info("DELETE : " + "Testimonial record deleted successfully");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This function performs the Pagination, Sorting and Filtering of the data and
	 * then returns the data to the user.
	 * 
	 * @param testimonialFilterVO Filter params to be applied.
	 * @param pageNumber          Offset parameter.
	 * @param pageSize            Limit parameter.
	 * @param sortBy              Key in DB to be sorted.
	 * @return
	 */

	public List<Testimonial> getSortedTestimonials(TestimonialFilterVO testimonialFilterVO, int offset, int limit,
			String sortBy) {
		Query query = new Query();
		Pageable pageable = PageRequest.of(offset, limit, Sort.by(sortBy));
		if (testimonialFilterVO != null) {
			if (testimonialFilterVO.getRegion() != null) {
				LOGGER.info("POST : " + "Testimonial record not found ");
				query.addCriteria(Criteria.where("region").is(testimonialFilterVO.getRegion()));
			}
			if (testimonialFilterVO.getTripType() != null) {
				query.addCriteria(Criteria.where("T_Type").is(testimonialFilterVO.getTripType()));
			}
			if (testimonialFilterVO.getDepartureCity() != null) {
				query.addCriteria(Criteria.where("DEP_CITY").is(testimonialFilterVO.getDepartureCity()));
			}
			if (testimonialFilterVO.getDateOfDeparture() != null) {
				query.addCriteria(Criteria.where("DEP_DATE").is(testimonialFilterVO.getDateOfDeparture()));
			}
			if (testimonialFilterVO.getStar() != null) {
				query.addCriteria(Criteria.where("star").is(testimonialFilterVO.getStar()));
			}
			if (testimonialFilterVO.getDestination() != null) {
				query.addCriteria(Criteria.where("destination").is(testimonialFilterVO.getDestination()));
			}
		}
		query.with(pageable);
		return mongoTemplate.find(query, Testimonial.class);
	}

	public List<Testimonial> searchTestimonials(String query) {
		Query search_query = new Query();
		LOGGER.info("search function entered");
		search_query.addCriteria(Criteria.where("destination").regex(Pattern.compile(query, Pattern.CASE_INSENSITIVE)));
		return mongoTemplate.find(search_query, Testimonial.class);
	}

}
