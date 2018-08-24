package com.java.example;



public class CustomerService {
	
	private String message;
	


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() throws Exception {
		System.out.println("Init method after properties are set : " + message);
	}
	
	public void destroy() throws Exception {
		
		System.out.println("Destroy method  set : " + message);
	}

}
