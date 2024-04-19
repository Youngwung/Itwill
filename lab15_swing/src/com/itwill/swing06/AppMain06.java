package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox; // (노란줄 원인)
	private JButton btnInfo;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	private JRadioButton selectedRadoButton;
	private ArrayList<JCheckBox> selectedCheckBoxes = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("Private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				handleRadioButtonClick(e); // e는 어떤 라디오버튼이 눌렸는 지에 대한 정보를 가지고 있으므로 아규먼트로 e를 준다. 
				// 라디오버튼 4개가 할 일이 같으므로 메서드로 처리.
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		rbPrivate.setHorizontalAlignment(SwingConstants.CENTER);
		rbPrivate.setBounds(8, 6, 138, 44);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("Package");
		rbPackage.addActionListener(new ActionListener() { // 익명클래스 활용 이벤트리스너 등록.
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setHorizontalAlignment(SwingConstants.CENTER);
		rbPackage.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		rbPackage.setBounds(150, 6, 138, 44);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("Protected");
		rbPackage.addActionListener((e) -> handleRadioButtonClick(e)); // 람다표현식 이벤트리스너 등록.
		buttonGroup.add(rbProtected);
		rbProtected.setHorizontalAlignment(SwingConstants.CENTER);
		rbProtected.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		rbProtected.setBounds(292, 6, 138, 44);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("Public");
		rbPublic.addActionListener(this::handleRadioButtonClick); // 람다표현식 메서드참조 이벤트리스너 등록.,
		buttonGroup.add(rbPublic);
		rbPublic.setHorizontalAlignment(SwingConstants.CENTER);
		rbPublic.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		rbPublic.setBounds(434, 6, 138, 44);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("Abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setHorizontalAlignment(SwingConstants.CENTER);
		cbAbstract.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cbAbstract.setBounds(8, 66, 138, 44);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener((e) -> handleCheckBoxClick(e));
		cbFinal.setHorizontalAlignment(SwingConstants.CENTER);
		cbFinal.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cbFinal.setBounds(150, 66, 138, 44);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("Static");
		cbStatic.addActionListener(this::handleCheckBoxClick);
		cbStatic.setHorizontalAlignment(SwingConstants.CENTER);
		cbStatic.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cbStatic.setBounds(292, 66, 138, 44);
		frame.getContentPane().add(cbStatic);
		
		comboBox = new JComboBox<>(); // List<E> 처럼 JComboBox는 <E>를 명시적으로 알려줘야 하는데 윈도우빌더가 이건 자동으로 해주지 못함.
		//comboBox = new JComboBox();
			// comboBox의 필드 선언 부분을 바꿔준다: private JComboBox comboBox	 =>   private JComboBox<String> comboBox;
		
			// 그리고 몇개 더 바꿔주면 경고(노란줄)이 없어지는데,
			// 
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"", "naver.com", "gmail.com", "kakao.com", "daum.net", "hanmail.com", "yahoo.co.kr"}));
		// comboBox.setModel(new DefaultComboBoxModel({"", "naver.com", "gmail.com", "kakao.com", "daum.net", "hanmail.com", "yahoo.co.kr"})); (노란줄 원인)
		comboBox.setBounds(8, 116, 280, 44);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener((e) -> handleButtonClick());
		btnInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btnInfo.setBounds(292, 116, 138, 44);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 170, 603, 209);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// -- 문자열들을 이어붙일 때 유용한 클래스 
		// JTextArea에 출력할 문자열들을 추가할(append) 문자열 버퍼
		StringBuffer buffer = new StringBuffer();
		// 어떤 라디오버튼이 선택되었는 지
//		if (rbPrivate.isSelected()) {
//			buffer.append(rbPrivate.getText());
//		} else if (rbPackage.isSelected()) {
//			buffer.append(rbPackage.getText());
//			
//		} else if (rbProtected.isSelected()) {
//			buffer.append(rbProtected.getText());
//			
//		} else if (rbPublic.isSelected()) {
//			buffer.append(rbPublic.getText());
//		}
		buffer.append(selectedRadoButton.getText());
		buffer.append(" 라디오버튼 선택됨.\n");
		
		// 문자열 버퍼의 내용을 JTextArea에 씀
		textArea.setText(buffer.toString());
		
		// 어떤 체크박스(들)이 선택되었는 지
//		if (cbAbstract.isSelected()) {
//			buffer.append(cbAbstract.getText()).append(" ");
//		}
//		if (cbFinal.isSelected()) {
//			buffer.append(cbFinal.getText()).append(" ");
//			
//		}
//		if (cbStatic.isSelected()) {
//			buffer.append(cbStatic.getText()).append(" ");
//		}
			for (JCheckBox x : selectedCheckBoxes) {
				buffer.append(x.getText()+" ");
			}
			buffer.append(" 체크박스 선택됨.\n");
		
		// 문자열 버퍼의 내용을 JTextArea에 씀
		textArea.setText(buffer.toString());
		// 콤보박스에서 선택된 아이템
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append(selectedItem);
		buffer.append(" 콤보박스 아이템 선택됨\n");
		textArea.setText(buffer.toString());
		
		
	}

	protected void handleComboBoxChange(ActionEvent e) {
		JComboBox<String> combo = (JComboBox<String>) e.getSource();
		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
		
		// 콤보박스에서 선택된 아이템 찾기
		int index = combo.getSelectedIndex();
		String item = (String) combo.getSelectedItem();
		
		// JTextArea에 정보 출력
		textArea.setText(index + ": "+ item);
		
	}

	protected void handleCheckBoxClick(ActionEvent e) {
		if (((JCheckBox) e.getSource()).isSelected()) {
			selectedCheckBoxes.add(((JCheckBox) e.getSource()));
		} else {
			selectedCheckBoxes.remove(e.getSource());
		}
//		String text = cb.getText();
//		boolean selected = cb.isSelected();
//		textArea.setText(text + ": " +selected);
		
		
	}

	private void handleRadioButtonClick(ActionEvent e) {
		// 4개의 라디오버튼들 중에서 누가 클릭되었는 지 찾기:
		selectedRadoButton= (JRadioButton) e.getSource();
		
		String text = selectedRadoButton.getText(); // "클릭된 라디오" 버튼의 텍스트를 가져오는 메서드.
		boolean selected = selectedRadoButton.isSelected(); // "클릭된 라디오" 버튼의 선택 여부.
		textArea.setText(text + ": " +selected);
		

	}


}
