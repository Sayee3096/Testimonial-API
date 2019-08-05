package com.pyt.veho.constants;

import java.util.UUID;

public class ConstantFunctions {
	 
	
	public static String GenerateUUID() {
		UUID uuid = UUID.randomUUID();
		String testimonialId = uuid.toString();
	    return testimonialId;
	}
}
