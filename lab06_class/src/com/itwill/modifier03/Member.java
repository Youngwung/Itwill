package com.itwill.modifier03;

public class Member {
	// field
	private String memberId; // 읽기 전용 필드
	private String memberPassword; // 읽기/쓰기 전용 필드로 만들고 싶음! => 메서드를 제공

	// constructor
	public Member(String memberId, String memberPassword) {
		if (memberId != null && memberPassword != null) { // 아이디와 패스워드 둘 다 null이 아니면, 필드를 초기화.
			this.memberId = memberId;
			this.memberPassword = memberPassword;
		} else {
			throw new IllegalArgumentException(); // null값을 전달받으면 강제적으로 오류를 일으켜 실행이 안되게 함.
		}
	}

	// method
	// getter 메서드
	public String getMemberId() {
		return this.memberId;
	}

	public String getMemberPassword() {
		return this.memberPassword;
	}

	// setter 메서드
	public void setMemberPassword(String password) {
		if (password != null) {				//null로 변경되지 않기 위한 코드.
			this.memberPassword = password;
		}
	}
}
