package com.itwill.prac_contact02;

public class Contact {
	//필드
	private String name;
	private String phone;
	private String email;
	//생성자
	public Contact() {}
	
	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		
	}
	
	//name
	public String getName() {
		return this.name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	//phone
	public String getPhone() {
		return this.phone;
	}
	public String setPhone(String phone) {
		return this.phone = phone;
	}
	//email
	public String getEmail() {
		return this.phone;
	}
	public String setEmail(String email) {
		return this.email = email;
	}
	//메서드
	
	public String toString() { 
		return "Contact/ name: "+this.name+
				" phone: " + this.phone + 
				" email: "+this.email;
	}

}
