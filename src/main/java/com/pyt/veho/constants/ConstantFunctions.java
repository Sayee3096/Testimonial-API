package com.pyt.veho.constants;

/*
 * FileName: ConstantFunctions.java
 * Version: V1
 * 
 * Functionality: This class includes the common user-defined functions that is used throughout
 * the application.
 */

import java.util.UUID;

public class ConstantFunctions {

	/*
	 * Function Name: GenerateUUID()
	 * 
	 * Functionality: This function is used to generate the Unique Universal
	 * Identifier to store the data in MongoDB. This function is called for every
	 * POST request to add new testimonial.
	 */

	public static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		String testimonialId = uuid.toString();
		return testimonialId;
	}
}
