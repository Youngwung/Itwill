package com.itwill.prac_contact03;

public class Contact {
	//필드
	private String name;
	private String phone;
	private String email;
	
	//생성자
	public Contact() {
		
	}
	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//메서드
	public String toString() {
		return "Contact/ name: "+name+" phone: "+ phone + " email: "+email;
	}
	
}
