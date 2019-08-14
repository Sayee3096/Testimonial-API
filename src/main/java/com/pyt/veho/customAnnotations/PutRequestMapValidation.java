package com.pyt.veho.customAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
@Constraint(validatedBy = PutRequestMapValidator.class)
public @interface PutRequestMapValidation {

	public Map<String, String> testimonialMap = new HashMap<>();

	public String message() default "Wrong key value is provided";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
