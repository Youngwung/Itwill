package com.itwill.prac_contact;

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
	// name
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// phone
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// email
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//메서드
	//연락처 정보(이름, 전화번호, 이메일)을 문자열로 리턴하는 메서드
		public String toString() {
			return "Contact(name="+this.name
					+", phone="+this.phone
					+", emali=" +this.email
					+ ")";
		}

}
