package com.itwill.file04;

import java.io.Serializable;

public class Product implements Serializable  { //OOS를 사용하기 위해서는 반드시 Serializable 인터페이스를 구현해야한다.
	//field
	private int code; // 상품 코드
	private String name; // 상품 이름
	private int price; // 상품 가격
	
	//constructor
	public Product() {}

	public Product(int code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	// get, set
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
