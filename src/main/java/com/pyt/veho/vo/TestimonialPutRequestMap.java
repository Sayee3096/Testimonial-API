package com.pyt.veho.vo;

import java.util.Map;

import com.pyt.veho.customAnnotations.PutRequestMapValidation;

public class TestimonialPutRequestMap {
	@PutRequestMapValidation
	private Map<String, String> testimonialRequestMap;

	public Map<String, String> getTestimonialRequestMap() {
		return testimonialRequestMap;
	}

	public void setTestimonialRequestMap(Map<String, String> testimonialRequestMap) {
		this.testimonialRequestMap = testimonialRequestMap;
	}
}
