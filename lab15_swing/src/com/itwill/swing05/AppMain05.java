package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnEnter;
	private JTextArea textArea;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	
	private String name;
	private String phone;
	private String email;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 855, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblName = new JLabel("이름");
		lblName.setBounds(101, 81, 119, 51);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		
		textName = new JTextField();
		textName.setBounds(264, 81, 289, 51);
		textName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(101, 156, 131, 51);
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		
		textPhone = new JTextField();
		textPhone.setBounds(264, 156, 289, 51);
		textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textPhone.setColumns(10);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setBounds(101, 231, 119, 51);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		
		textEmail = new JTextField();
		textEmail.setBounds(264, 231, 289, 51);
		textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textEmail.setColumns(10);
		
		btnEnter = new JButton("입 력");
		btnEnter.setBounds(612, 231, 137, 51);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 텍스트필드에 입력된 값을 저장
				name = textName.getText();
				phone = textPhone.getText();
				email = textEmail.getText();
				
				// 텍스트필드의 정보를 문자열로 저장.
				String msg = String.format(
						 "이름: %s "
						+ "전화번호: %s "
						+ "이메일: %s \n"
						, name, phone, email);
//				textArea.setText(msg);
				//비우고 새로쓰는 명령어
				
				textArea.append(msg);
				//기존에 작성된 내용 끝에 추가(자체적으로 줄바꿈 기능을 가지고 있진 않음)
				
				//입력 받은 후 입력창을 비우는 코드.
				textName.setText("");
				textPhone.setText("");
				textEmail.setText("");
				
			}
		});
		btnEnter.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 314, 648, 114);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblName);
		frame.getContentPane().add(textName);
		frame.getContentPane().add(lblPhone);
		frame.getContentPane().add(textPhone);
		frame.getContentPane().add(lblEmail);
		frame.getContentPane().add(textEmail);
		frame.getContentPane().add(btnEnter);
		frame.getContentPane().add(scrollPane);
	}
}
