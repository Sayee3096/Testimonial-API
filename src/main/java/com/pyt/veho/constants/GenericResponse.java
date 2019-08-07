package com.pyt.veho.constants;

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
