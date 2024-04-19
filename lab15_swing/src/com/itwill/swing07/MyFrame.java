package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class MyFrame extends JFrame {
	
	public interface Notifiable {
		public void notifyMessage(String msg);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn;
	private JTextField textField;
	
	private Component parentComponent; // 부모 컨포넌트 frame을 저장하기 위한 필드.
//	private AppMain07 app; // 메인클래스의 현재 생성된 객체의 주소를 저장하기 위한 필드. 
	private Notifiable app; // 클래스 다형성을 위한 업그레이드
	// notifyMessage(String msg) 메서드를 갖는 객체의 주소를 저장.
	// 이미 객체가 생성되고 실행되고 있기 때문에 새로운 객체를 만드는 방법으로 메인클래스의 접근할 수 없음.

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parentComponent, Notifiable app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame(parentComponent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MyFrame(Component parentComponent, Notifiable app) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}
	
	public void initialize() {
		
		
		// JFrame의 닫기 버튼의 기본 동작을 설정:
		// EXIT_ON_CLOSE: 프로그램 종료(메인 쓰레드 종료)
		// DISPOSE_ON_CLOSE: 현재 JFrame만 닫음 (메인 쓰레드는 계속 실행)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parentComponent != null) { // frame이 null인 경우 x, y좌표를 0 0으로 만듬.
			x = parentComponent.getX(); // 부모 컴포넌트의 x좌표
			y = parentComponent.getY(); // 부모 컴포넌트의 y좌표.
		} 
		setBounds(x, y, 450, 300);
		
		if (parentComponent == null) { // 부모 컴포넌트 정보가 없을 때
			setLocationRelativeTo(null); // 화면 중앙에 위치시킴.
		}
//		setBounds(parentComponent.getBounds());  //크기도 똑같이 맞춰버려서 위치만 똑같이 맞추고 싶다면 좌표만을 바꾸고 싶다면 다른 메서드 활용.
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btn = new JButton("확인");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JTextField의 내용을 읽음.
				String msg = textField.getText();
				app.notifyMessage(msg);
				
				
			}
		});
		btn.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
						.addComponent(btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addGap(149))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
