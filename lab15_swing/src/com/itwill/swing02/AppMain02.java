package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JLabel lblMessage;
	private JTextField textInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 294);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// ------------------------label 설정-------------------------
		lblMessage = new JLabel("메시지를 입력하세요....");
		lblMessage.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 10, 654, 61);
		frame.getContentPane().add(lblMessage);
		
		//-------------------------JTextField 설정 --------------------
		textInput = new JTextField();
		textInput.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		textInput.setBounds(12, 81, 654, 61);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		//-------------------------JButton 설정 --------------------
		
		JButton btnInput = new JButton("입력");
		
		//-------//버튼에 ActionListener 이벤트 핸들러(리스너)를 설정(등록)
		btnInput.addActionListener(new ActionListener() {
			@Override // 버튼이 클릭됐을 때 할 일을 작성.
			public void actionPerformed(ActionEvent e) {
				// (지역) 내부 클래스에서는 외부 클래스의 메서드를 사용할 수 있음. => 
				handleInputButtonClick();
			}
		});
		
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		btnInput.setBounds(258, 166, 152, 61);
		frame.getContentPane().add(btnInput);
	}

	private void handleInputButtonClick() {
			// 바깥에 만들었을 때의 장점은 메인클래스의 멤버들을 사용할 수 있음.
		
		// 1. JTextField에 입력된 문자열을 읽음.
		String msg = textInput.getText(); // 참조변수로 함수찾기. 가져오기 get, 바꾸기 set => 바꿀 타입게 text니까 이런거 고려해서 찾기
//		System.out.println(msg); // 입력된 내용을 잘 출력하는 지 확인
		
		// 2. (1)에서 읽은 내용을 JLabel에 씀.
		lblMessage.setText(msg);
		// 3. JTextField를 비움(입력된 내용을 지운다).
//		textInput.removeNotify(); // 입력 한번 받고 입력창을 비활성화함.
		textInput.setText(""); // '지운다'보다 비어있는 문자열로 바꾼다는 개념.
		
	}
}
