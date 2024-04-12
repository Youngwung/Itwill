package com.itwill.inner03;

public class Button {
	// public static 내부 인터페이스 -> static은 생략 가능.[static만 가능하기 때문]
	public interface OnClickListener {
		void onClick(); // [public abstract] 추상메서드.
	}

	//field
	private String btnName;
	private OnClickListener listener;
	
	//constructor
	public Button(String btnName) {
		this.btnName = btnName;
	}
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// method
	public void click() {
		System.out.print(btnName + "버튼:");
		listener.onClick();
	}
	
}
