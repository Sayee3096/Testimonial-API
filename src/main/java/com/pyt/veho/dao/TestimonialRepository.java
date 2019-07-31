package com.pyt.veho.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pyt.veho.model.Testimonial;

public interface TestimonialRepository extends MongoRepository<Testimonial,Integer> {

}
