package com.pyt.veho.customAnnotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.pyt.veho.model.Testimonial;

@Component
public class PutRequestMapValidator implements ConstraintValidator<PutRequestMapValidation, Map<String, String>> {

	@Override
	public boolean isValid(Map<String, String> testimonialMap, ConstraintValidatorContext context) {
		Testimonial testimonial = new Testimonial();
		Map<String, Boolean> testimonialPojo = new HashMap<String, Boolean>();
		Class TestimonialCompare = testimonial.getClass();
		Field[] testimonialFields = TestimonialCompare.getDeclaredFields();
		for (Field f : testimonialFields) {
			testimonialPojo.put(f.getName(), true);
		}

		for (String key : testimonialMap.keySet()) {

			if (testimonialPojo.get(key) == null) {
				return false;
			}
		}
		return true;
	}

}
