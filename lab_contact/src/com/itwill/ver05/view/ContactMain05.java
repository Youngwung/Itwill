package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;
import com.itwill.ver05.view.ContactUpdateFrame.UpdateNotify;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

public class ContactMain05 implements CreateNotify, UpdateNotify{
	
	private static final String[] COLUMN_NAMES = {"이름", "전화번호"};
	
	private ContactDao dao = ContactDaoImpl.getInstance(); // 싱글턴 객체 생성

	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnCreate;
	private JScrollPane scrollPane;
	private JTable table;
	
	private DefaultTableModel model; // 테이블을 사용하기위한 필드.
	private JButton btnUpdate;
	private JButton btnSearch;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		initialize(); // UI 컴포넌트들(버튼, 테이블, ...)을 생성, 초기화
		loadContactData(); // ContactDao를 사용해서 파일에 저장된 연락처 데이터를 테이블에 로딩. (만들거)
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("연락처 v0.5");
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		
		btnCreate = new JButton("추가");
		btnCreate.addActionListener((ActionEvent e) -> 
				ContactCreateFrame.showContactCreateFrame(frame, ContactMain05.this)
				);
		btnCreate.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnCreate);
		
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener((e) -> {
			int index = table.getSelectedRow();
			if (index == -1) { // 열을 선택하지 않았을 때 다이얼그럼 메세지 출력 후 메인화면으로 돌아감.
				JOptionPane.showMessageDialog(frame, "수정할 행을 선택해주세요...", "수정 실패", JOptionPane.WARNING_MESSAGE);
			} else {
				ContactUpdateFrame.showContactUpdateFrame(index, ContactMain05.this, frame);
			}
			});
		
		btnUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnUpdate);
		
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deleteContact());
		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnDelete);
		
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> ContactSearchFrame.showContactSearchFrame(frame));
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		buttonPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		// 테이블 컬럼 이름의 폰트 설정 => windowbuilder에 없음.
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		// 테이블 데이터 행의 폰트 설정 => windowbuilder에 없음.
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		// 테이블 행 높이(세로) 설정 => windowbuilder에 없음.
		table.setRowHeight(40);
		model = new DefaultTableModel(null, COLUMN_NAMES); // 테이블에 타이틀을 보여줌.
		table.setModel(model);
		scrollPane.setViewportView(table);
	}


	private void loadContactData() {
		List<Contact> list = dao.read();
		// 리스트의 연락처들을 테이블에 행으로 추가.
		for (Contact c : list) {
			Object[] row = {c.getName(), c.getPhone()};
			model.addRow(row);
		}
		
	}

	@Override // ContactCreateFreame.CreateNotify 인터페이스의 메서드 재정의.
	public void notifyContactCreated() {
		// 테이블 데이터 다시 로딩.
		
//		// 데이터를 모두 지운 새로운 테이블 모델 객체를 생성.
//		model = new DefaultTableModel(null, COLUMN_NAMES);
//		// 파일에 저장된 연락처(새 연락처가 추가된 데이터)를 로딩
//		loadContactData();
//		// 새 테이블 모델을 테이블에 다시 세팅
//		table.setModel(model);
		// 같은 코드가 반복되므로 메서드로 만들기.
		resetTable();
		//사용자에게 알림
		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
	}

	private void deleteContact() {
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(frame, "삭제할 행을 선택해주세요...", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame, "정말로 삭제하시겠습니까?", "삭제 여부", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			// DAO를 사용해서 선택된 연락처를 삭제하고, 파일에 저장.
			int result = dao.delete(index);
			if (result == 1) {
				// 테이블을 초기화하고 변경사항을 테이블에 새로 쓰는 메서드.
				resetTable();
				JOptionPane.showMessageDialog(frame, "삭제 성공!");
			} else {
				// TODO 삭제 실패 메세지.
			}
		}
		
	
	}
	private void resetTable() {
		// 데이터를 모두 지운 새로운 테이블 모델 객체를 생성.
		model = new DefaultTableModel(null, COLUMN_NAMES);
		// 파일에 저장된 연락처(새 연락처가 추가된 데이터)를 로딩
		loadContactData();
		// 새 테이블 모델을 테이블에 다시 세팅
		table.setModel(model);
	}

	@Override
	public void notifyContactUpdated() {
		resetTable();
		JOptionPane.showMessageDialog(frame, "수정 완료!");
	}

}
