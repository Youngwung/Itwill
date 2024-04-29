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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	public interface UpdateNotify {
		public void notifyContactUpdated();
	}

	private UpdateNotify app; // 메인 쓰레드 주소를 저장하기 위한 객체
	
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위해서
	
	
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
	
	private int index;
	private ContactDao dao = ContactDaoImpl.getInstance();
	private JPanel buttonPanel;

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(int index, UpdateNotify app, Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(index, app, parentComponent);
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
	
	public ContactUpdateFrame(int index, UpdateNotify app, Component parentComponent) {
		this.index = index;
		this.app = app;
		this.parentComponent = parentComponent;
		initialize();
		initializeTextFields();
	}
	
	public void initializeTextFields() {
		// 3개의 텍스트필드에 해당 인덱스의 연락처 정보를 채움.
		// 자동 생성된 메서드들 사이에 껴있으면 구현이 되어있는지 안되어있는지
		// 구분이 힘드므로 initialize()메서드가 끝난 후 텍스트 필드에 정보를 채운다.
		// initialize()메서드 끝나고 써야하는 이유는 텍스트필드들이 모두 new~~ 하고 초기화가 끝나야
		// setText를 쓸수 있기 때문.
		Contact contact = dao.read(index);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	public void initialize() {
	
		
		setTitle("연락처 업데이트");
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
		textName.setText(getName());
//		textName.setText(dao.read(index).getName()); // 나중에 메서드로 한번에 함.
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
//		textPhone.setText(dao.read(index).getPhone());
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
//		textEmail.setText(dao.read(index).getEmail());
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("수정");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String phone = textPhone.getText();
				String email = textEmail.getText();
				Contact contact = new Contact(0, name, phone, email);
				int result = dao.update(index, contact);
				if (result == 1) {
					app.notifyContactUpdated();
					dispose();
				} else {
					//TODO 수정 실패시...
				}
			}
		});
		btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnCancle);
	}

}
