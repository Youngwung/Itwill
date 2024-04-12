package com.itwill.enum01;

public enum Season3 {
	SPRING("봄"), // public static final Season3 SPRING = new Season3("봄"); 과 같음
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");
										// 기본생성자가 있으면 객체를 새로만들어 참조값을 바꿔버릴 수 있다.
	private String name;				// 클래스로 같은 효과를 보려면 아규먼트를 갖는 생성자를 하나 만들어 기본생성자를 없애야한다.
	
	//Enum은 생성자를 public으로 만들 수 없다. 반드시 private. 
	//아규먼트를 갖는 생성자를 만들면 선언한 Enum들은 에러메세지가 나옴
	// 그 이유는 기본생성자가 없어지기 때문.
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능.
	private Season3() {
	}	
	
	private Season3(String name) {
		this.name = name;			
	}

	
    public String getName() {
        return this.name;
    }
    

}


