package com.itwill.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AppMain01 {

	private JFrame frame; // 만들 Windows 창
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// JRE에 의해서 실행될 쓰레드를 등록.
		EventQueue.invokeLater(new Runnable() {
			@Override // run 메서드: 쓰레드가 할 일.
			public void run() {
				try {
					AppMain01 window = new AppMain01(); 
					window.frame.setVisible(true); // JFrame 객체를 화면에 보여줌
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 필드 초기화 - JFrame 객체 생성
		frame = new JFrame(); 
		
		// setBounds(x, y, w, h): JFrame의 시작 좌표(x, y)와 크기(w, h)를 설정.
		// (x좌표, y좌표, x축 길이, y축 길이). 원점은 모니터왼쪽 위.
		frame.setBounds(200, 200, 600, 400); 
		
		// JFrame의 우상단에 있는 닫기 버튼(X)의 기능을 설정 - 프로그램 종료.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMessage = new JLabel("안녕하세요, Swing!!");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		frame.getContentPane().add(lblMessage, BorderLayout.CENTER);
		
	}

}
