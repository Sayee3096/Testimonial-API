package com.pyt.veho.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyt.veho.constants.ConstantFunctions;
import com.pyt.veho.constants.GenericResponse;
import com.pyt.veho.dao.TestimonialDAO;
import com.pyt.veho.model.Testimonial;
import com.pyt.veho.vo.TestimonialFilterVO;

@Service
public class TestimonialService {

	@Autowired
	private TestimonialDAO testimonialDao;

	/**
	 * This function calls the getTestimonial function in the DAO layer which
	 * returns all the testimonials from MongoDB.
	 *
	 * @return All testimonials from DB.
	 */

	public List<Testimonial> getTestimonials() {
		return testimonialDao.getTestimonial();
	}

	/**
	 * This function calls the getTestimonialById function in the DAO layer which
	 * returns the testimonial which corresponds to the respective testimonial_id
	 * from MongoDB.
	 *
	 * @param id Id of the testimonial to be retrieved.
	 * @return Single testimonial.
	 */

	public GenericResponse getTestimonialById(String id) {
		return testimonialDao.getTestimonialById(id);
	}

	/**
	 * This function calls the saveTestimonial function in the DAO layer which saves
	 * a new testimonial to the Database. The UUID is generated and added to the
	 * Testimonial Request Body in this function.
	 *
	 * @param testimonial Testimonial to be saved.
	 */

	public void saveTestimonial(Testimonial testimonial) {
		String testimonialId = ConstantFunctions.generateUUID();
		testimonial.setTestimonialId(testimonialId);
		testimonialDao.saveTestimonial(testimonial);
	}

	/**
	 * This function calls the editTestimonial function in the DAO layer updates the
	 * existing testimonial with the updated parameters given by the user in the
	 * Request Body.
	 *
	 * @param testimonial Keys to be updated.
	 * @param id          Id of the testimonial to be updated.
	 */

	public void editTestimonial(Map<String, String> testimonial, String id) {
		testimonialDao.editTestimonial(testimonial, id);
	}

	/**
	 * This function calls the getSortedTestimonials from the DAO layer which
	 * performs the Pagination, Filtering and Sorting of the testimonials as
	 * requested by the User.
	 *
	 * @param testimonialFilterVO Filter params to be updated.
	 * @param pageNumber          Offset Parameter
	 * @param pageSize            Limit Parameter
	 * @param sortBy              Key to be sorted.
	 * @return Filtered and sorted Testimonaial with Paging.
	 */

	public List<Testimonial> getSortedTestimonials(TestimonialFilterVO testimonialFilterVO, int pageNumber,
			int pageSize, String sortBy) {
		return testimonialDao.getSortedTestimonials(testimonialFilterVO, pageNumber, pageSize, sortBy);
	}

	/**
	 * This function calls the deleteTestimonialById function in the DAO layer which
	 * deletes the testimonial which corresponds to the respective testimonial_id
	 * from MongoDB.
	 *
	 * @param id Id of the testimonial to be removed.
	 */

	public GenericResponse deleteTestimonialById(String id) {
		return testimonialDao.deleteTestimonialById(id);

	}

}
