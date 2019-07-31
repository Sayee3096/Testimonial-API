package com.pyt.veho.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pyt.veho.model.Testimonial;

@Service
public class TestimonialService {
	
	private List<Testimonial> testimonials = new ArrayList<>(Arrays.asList(
			new Testimonial(1, "5a2b92b94065d117076a2d3a", "Gowtham", "", "", Arrays.asList("Photo_one", "Photo_two")),
			new Testimonial(2, "5a2b92b94065d117076a2d3b", "Shan", "", "", Arrays.asList("Photo_one", "Photo_two")),
			new Testimonial(3, "5a2b92b94065d117076a2d3c", "Saran", "", "", Arrays.asList("Photo_one", "Photo_two")),
			new Testimonial(4, "5a2b92b94065d117076a2d3d", "Sayee", "", "", Arrays.asList("Photo_one", "Photo_two"))));
	
	public List<Testimonial> getTestimonials(){
		return this.testimonials;
	}
	
	public Testimonial getTestimonial(int id) {
		Testimonial testimonial = testimonials.stream().filter(t -> t.getTestimonialId() == id).findAny().orElse(null);
		return testimonial;
	}
	
	public void newTestimonial(Testimonial testimonial) {
		testimonials.add(testimonial);
	}
	
	public void editTestimonial(Testimonial testimonial,int id) {
		for(Testimonial t : testimonials) {
			if(t.getTestimonialId() == id) {
				testimonials.set(testimonials.indexOf(t), testimonial);
			}
		}
	}
	 public void deleteTestimonial(int id) {
		 testimonials.removeIf(t -> t.getTestimonialId() == id);
	 }
}
