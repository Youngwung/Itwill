package com.itwill.inheritance06;


import java.util.Objects;

public class User {
	//field
	private String id;
	private String password;
	
	//constructors
	public User() {}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId () {
		return this.id;
	}
	public void setId (String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//toString 재정의 - id와 password를 출력
	@Override
	public String toString() {
		return "id: "+id+" password: "+password;
	}
	
	
	//equals 재정의 - id만 같으면 같은 객체, 그렇지 않으면 다른 객체.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User && id != null) { // 호출한 객체가 null 인지도 검사.
			User user = (User) obj;
			return id.equals(user.id); // 
		}
		return false;
	}
	
	
	// hashCod 재정의 - id가 같은 User 객체는 같은 정수값이 리턴되도록.
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return id.hashCode();
//	}

	
	// 자바에서 자동으로 만들어준 equals 와 hash코드
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(id, other.id);
//	}
	
	

}
