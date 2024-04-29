package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ContactCreateFrame extends JFrame {
	
	public interface CreateNotify {
		public void notifyContactCreated();
	}

	private ContactMain05 app; 
	// 연락처 저장 성공을 알려줄 객체
	// 메인클래스의 이미 생성된 객체(인스턴스) 멤버를 가져올 수 있게 메인과 서브클래스의 다리역할을 하는 필드. 
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JButton btnSave;
	private JButton btnCancle;
	private JLabel lblName;
	private JTextField textName;
	private JLabel lblPhone;
	private JTextField textPhone;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JPanel buttonPanel;
	
	private Component parentComponent; // CreateFrame의 부모 컴포넌트
	
	private ContactDao dao = ContactDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parentComponent, ContactMain05 app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parentComponent, app);
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
	
	public ContactCreateFrame(Component parantComponent, ContactMain05 app) {
		this.app = app;
		this.parentComponent = parantComponent;
		intialize();
	}
	
	public void intialize() {
		setTitle("새 연락처");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			// 부모 컴포넌트가 있으면 부모 컴포넌트와 같은 좌표(x, y)에 위치 시키고
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 561, 328);
		
		if (parentComponent == null) { // 부모 컴포넌트가 없으면 화면중앙에 위치시킴.
			setLocationRelativeTo(null);
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(12, 14, 146, 42);
		contentPanel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		textName.setBounds(170, 14, 353, 42);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblPhone.setBounds(12, 70, 146, 42);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		textPhone.setColumns(10);
		textPhone.setBounds(170, 70, 353, 42);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblEmail.setBounds(12, 126, 146, 42);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		textEmail.setColumns(10);
		textEmail.setBounds(170, 126, 353, 42);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> saveContact()); // 입력한 내용 저장.
		
		btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("취소");
		
		btnCancle.addActionListener((e) -> dispose()); // 취소버튼 눌렸을 때 창만 종료
		
		btnCancle.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnCancle);
	}

	private void saveContact() {
		// 1. JTextField에서 저장할 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// 2. Contact 타입 객체 생성
		Contact contact = new Contact(0, name, phone, email);
		
		// 3. DAO를 사용해서 파일에 저장
		int result = dao.create(contact);
		if (result == 1) { // 연락처 저장성공
			//TODO ContactMain에게 연락처 저장이 성공됐음을 알려줌.
			app.notifyContactCreated();
			dispose(); // 현재 창 닫기
		} else { // 연락처 저장 실패
			//TODO 사용자에게 저장 실패 메시지 보여주기.
		}
	}

}
