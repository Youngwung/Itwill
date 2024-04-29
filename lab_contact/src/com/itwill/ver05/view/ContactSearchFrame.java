package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.List;

public class ContactSearchFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final String[] COLMUMN_NAMES = {"이름", "전화번호", "이메일"};
	
	private DefaultTableModel model;
	
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	private JPanel contentPane;

	private Component parentComponent;
	private JPanel headerPanel;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable Table;
	
	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrame frame = new ContactSearchFrame(parentComponent);
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
	
	public ContactSearchFrame(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}
	
	public void initialize() {
		setTitle("연락처 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			x = parentComponent.getX(); // 부모컴포넌트의 위치랑 같은곳에 창을 띄움.
			y = parentComponent.getY();
		}
		setBounds(x, y, 624, 479);
		if (parentComponent == null) {
			setLocationRelativeTo(null); // 화면 중앙에 배치
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		headerPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> searchByKeyword());
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		headerPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		Table = new JTable();
		
		// 테이블 컬럼 이름의 폰트 설정 => windowbuilder에 없음.
		Table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		// 테이블 데이터 행의 폰트 설정 => windowbuilder에 없음.
		Table.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		// 테이블 행 높이(세로) 설정 => windowbuilder에 없음.
		Table.setRowHeight(40);
		
		model = new DefaultTableModel(null, COLMUMN_NAMES);
		Table.setModel(model);
		scrollPane.setViewportView(Table);
	}

	private void searchByKeyword() {
		// 검색어 읽기
		String keyword = textField.getText();
		// Dao를 사용해서 검색어로 검색 결과를 가져옴
		List<Contact> list = dao.search(keyword);
		
		model = new DefaultTableModel(null, COLMUMN_NAMES); // 데이터 지움.
		
		// 검색 결과를 테이블에 씀.
		for(Contact x : list) {
			// Object타입의 배열이어야함.
			Object[] row = {x.getName(), x.getPhone(), x.getEmail()};
			model.addRow(row);
 		}
		
		Table.setModel(model); // 테이블에 테이블 모델을 다시 세팅. 
		
	}

}
