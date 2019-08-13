package com.pyt.veho.constants;

/*
 * FileName: GenericResponse.java
 * 
 * Functionality: This class is used to create a Generic Response format for every request the 
 * user sends. It will always be in this format throughout the application.
 */

public class GenericResponse {

	private String status = GenericResponseStatus.SUCCESS.name();
	private int responseCode = 200;
	private String message;
	private Object data = null;

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

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
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
