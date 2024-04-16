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
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblName.setBounds(101, 81, 119, 51);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textName.setBounds(264, 81, 289, 51);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblPhone.setBounds(101, 156, 131, 51);
		frame.getContentPane().add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textPhone.setColumns(10);
		textPhone.setBounds(264, 156, 289, 51);
		frame.getContentPane().add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblEmail.setBounds(101, 231, 119, 51);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textEmail.setColumns(10);
		textEmail.setBounds(264, 231, 289, 51);
		frame.getContentPane().add(textEmail);
		
		btnEnter = new JButton("입 력");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textName.getText();
				phone = textPhone.getText();
				email = textEmail.getText();
				String msg = String.format(
						  "이름: %s\n"
						+ "전화번호: %s\n"
						+ "이메일: %s\n"
						, name, phone, email);
				textArea.setText(msg);
			}
		});
		btnEnter.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnEnter.setBounds(612, 231, 137, 51);
		frame.getContentPane().add(btnEnter);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textArea.setBounds(101, 314, 648, 114);
		frame.getContentPane().add(textArea);
	}

}
