package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itwill.swing07.MyFrame.Notifiable;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 implements Notifiable {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnMyframe;

	public void notifyMessage(String message) {
		btnMyframe.setText(message);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메세지 다이얼로그 보여주기
//				JOptionPane.showMessageDialog(frame, "안녕하세요"); // 창을 띄울 위치: frame, 문자열은 그 창에 출력할 메세지.
				// 창을 띄울 위치에 null을 주면 모니터 한 가운데에 띄움
				
				JOptionPane.showMessageDialog(
						frame, // 부모 컴포넌트
						"안녕하세요", // 다이얼로그 메세지
						"인사", // 다이얼로그 타이틀(제목)
						JOptionPane.PLAIN_MESSAGE // 메시지 타
						);
			}
		});
		btnMsgDlg.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btnMsgDlg.setBounds(12, 14, 410, 43);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Confirm(확인) 다이얼로그 보여주기
//				int result = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까?");
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴포넌트
						"정말 삭제하시겠습니까?", // 메시지 
						"삭제 확인", // 타이틀
						JOptionPane.YES_NO_OPTION, // 옵션 타입(버튼 종류, 개수) 
						JOptionPane.QUESTION_MESSAGE  // 메시지 타입
						);
				btnConfirmDlg.setText("confirm="+ result);
						
			}
		});
		btnConfirmDlg.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btnConfirmDlg.setBounds(12, 71, 410, 43);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//showinputdialog
//				String inputDialog = JOptionPane.showInputDialog(frame, "버튼 이름 변경:", "변경할 이름 입력");
//				btnInputDlg.setText(inputDialog);
				String[] selections = {"인*", "얼굴장부", "X", "너튜브"};
				Object result = JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트
						"검색어 입력", 
						"검색어", 
						JOptionPane.PLAIN_MESSAGE, 
						null, // 아이콘 
						selections, // 선택할 값들
						selections[1] // 초기 선택값
						);
				btnInputDlg.setText("입력: " + result);
				
			}
		});
		btnInputDlg.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btnInputDlg.setBounds(12, 131, 410, 43);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.setBounds(12, 188, 410, 43);
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO	내가 만든 다이얼로그 보여주기 =>클래스 만들어야함
				// windowbuilder - swing disigner -> JDialog
				MyDialog.showMyDialog(frame);
				
			}
		});
		btnCustomDlg.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		frame.getContentPane().add(btnCustomDlg);
		
		btnMyframe = new JButton("Custom Frame");
		btnMyframe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// JFrame을 상속받는 객체 보여주기
				MyFrame.showMyFrame(frame, AppMain07.this);
				// -> 아규먼트 frame: Myframe 클래스가 부모 컴포넌트(Jframe) 정보를 사용할 수 있도록
				// -> 아규먼트 AppMain07.this: AppMain07 타입으로 생성된 객체(의 주소). 현재 객체.
				// MyFrame 클래스에서 AppMain07 객체의 public 메서드를 호출할 수 있도록.
			}
		});
		
		btnMyframe.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btnMyframe.setBounds(12, 245, 410, 43);
		frame.getContentPane().add(btnMyframe);
	}

}
