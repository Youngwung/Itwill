package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};
	private DefaultTableModel model;

	private JFrame frame;
	private JLabel lblKorean;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JScrollPane scrollPane;
	private JButton btnEnter;
	private JLabel lblMath;
	private JLabel lblEnglish;
	private JTable scoreTable;
	private JButton btnRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();
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
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 654, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblKorean = new JLabel("국어");
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		textKorean.setHorizontalAlignment(SwingConstants.LEFT);
		textKorean.setColumns(10);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		
		textEnglish = new JTextField();
		textEnglish.setHorizontalAlignment(SwingConstants.LEFT);
		textEnglish.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		textEnglish.setColumns(10);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		
		textMath = new JTextField();
		textMath.setHorizontalAlignment(SwingConstants.LEFT);
		textMath.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		textMath.setColumns(10);
		
		btnEnter = new JButton("입력");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputScoreToTable(); // 이 메서드에 액션이벤트를 아규먼트로 줘야하는가?
				// 버튼이 1개이고 클릭 액션밖에 없기 때문에 아규먼트가 필요없다.
				
			}
		});
		btnEnter.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		
		scrollPane = new JScrollPane();
		
		btnRemove = new JButton("삭제");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteScoreFromTable();
			}
		});
		btnRemove.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKorean, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textKorean, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnglish, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textEnglish, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMath, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textMath, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textKorean, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKorean, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnglish, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(textEnglish, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMath, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(textMath, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addGap(176))
		);
		
		scoreTable = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		scoreTable.setModel(model); // 코드 변형
		// 필드
//		scoreTable.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {"국어", "영어", "수학", "총점", "평균"}
//		));
		scoreTable.getColumnModel().getColumn(4).setPreferredWidth(72);
		scoreTable.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		scrollPane.setViewportView(scoreTable);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void deleteScoreFromTable() {
		// JTable에서 선택된 행의 인덱스를 찾음.
		int index = scoreTable.getSelectedRow();
		if (index == -1) { // 테이블에서 선택된 행이 없을 때 SelectedRow()는 -1을 리턴한다.
			JOptionPane.showMessageDialog(
					frame,
					"테이블에서 삭제할 행을 먼저 선택하세요...", 
					"경고", 
					JOptionPane.WARNING_MESSAGE
					);
			return; // 삭제 시도를 했을 때 메서드 종료
		}
		// 삭제 여부를 사용자에게 확인
		int confirm = JOptionPane.showConfirmDialog(
				frame, 
				"정말로 삭제하시겠습니까?", 
				"삭제",
				JOptionPane.YES_NO_OPTION , 
				JOptionPane.QUESTION_MESSAGE
				);
		if (confirm == JOptionPane.YES_OPTION) {
			model.removeRow(index); // 테이블(모델)에서 해당 인덱스의 행(row)를 삭제.
		} 
	}

	protected void inputScoreToTable() {
		// 1. JTextField에서 3과목의 점수를 읽음.
		int korean = 0;
		int english = 0;
		int math = 0;
		try {
			korean = Integer.parseInt(textKorean.getText());
			english = Integer.parseInt(textEnglish.getText());
			math = Integer.parseInt(textMath.getText());
		} catch (NumberFormatException a) {
			//TODO 메시지 다이얼로그 띄우기
			JOptionPane.showMessageDialog(
					frame,
					"국어, 영어, 수학 점수는 정수로 입력... ",
					"Exception",
					JOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		// 2. Score 타입 객체를 생성
		Score score = new Score (korean, english, math);
		
		// 3. JTable에 행(row)을 추가.
		model = (DefaultTableModel) scoreTable.getModel();
		model.addRow(new Object[] {score.getKorean(), score.getEnglish(), score.getMath(), score.getTotal(), score.getMean()});
		// 4. JTextField의 내용을 모두 지움.
		clearAllTextFields();
	}
	private void clearAllTextFields() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
}
