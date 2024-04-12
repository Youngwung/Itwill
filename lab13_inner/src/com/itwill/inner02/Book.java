package com.itwill.inner02;

public class Book {
	
	private String title; // 제목
	private String author; // 저자
	private String publisher; // 출판사
	
	public Book() {}
	
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	public Book(String title) {
//		this.title = title;
		this(title, null, null); // 오버로딩된 다른 생성자 호출
	}
	// overloading되지 않는 경우:
//	public Book(String author) { // 아규먼트 타입이 같기 때문에 저자만 초기화하는 생성자를 만들 수 없다.
//		this.author = author;
//	}
	
	public Book(String title, String author) {
		this(title, author, null);
//		this.title = title;
//		this.author = author;
	}
	//overloading되지 않는 경우2:
//	public Book(String title, String publisher) { // 마찬가지로 String 아규먼트 두개를 갖는 생성자를 만들수 없다.
//		this(title, null, publisher);
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Book(제목: %s, 저자: %s, 출판사: %s)", title, author, publisher);
	}

	// --- Builder(Factory) 디자인 패턴
	public static BookBuilder builder() {
		return new BookBuilder();
		// 외부 클래스에서 내부 클래스의 private 생성자를 호출할 수 있음.
	}
	
	public static class BookBuilder {
		private String title;
		private String author;
		private String publisher;
		
		private BookBuilder() {}
		
		public BookBuilder title(String title) {
			this.title = title;
			return this;
		}
		public BookBuilder author(String author) {
			this.author = author;
			return this;
		}
		public BookBuilder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}
		
		public Book bulid() {
			return new Book(title, author, publisher);
		}
	}// end class BookBuilder
	
	// ----
	
} // end class Book
