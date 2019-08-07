package com.pyt.veho.constants;

/*
 * FileName: GenericResponse.java
 * 
 * Functionality: This class is used to create a Generic Response format for every request the 
 * user sends. It will always be in this format throughout the application.
 */

public class GenericResponse {
	private String status = GenericResponseStatus.SUCCESS.name();
	private String message;
	private Object data;
	
	public GenericResponse() {
		
	}
	public GenericResponse(Object data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}


}
