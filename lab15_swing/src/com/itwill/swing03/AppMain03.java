package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {
	
	private static final String[] IMAGES = {
			"images/돼지.jpg", 
			"images/등대.jpg", 
			"images/물새.jpg", 
			"images/사슴.jpg", 
			"images/하늘.jpg"
			};
	private int curIndex = 0; 
	private JFrame frame;
	private JLabel lblImage;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblImageName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(100, 25, 200, 200);
		frame.getContentPane().add(lblImage);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO 이전 이미지 보여주기: 5 -> 4 -> 3-> 2-> 1-> 5
				if (curIndex == 0) { // 인덱스가 0인경우
					curIndex = IMAGES.length-1; // 마지막 인덱스로 이동
				} else { // 인덱스가 0이 아닌 경우
					curIndex--; // 인덱스 감소
				}
				lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
				lblImageName.setText(IMAGES[curIndex].replace("images/", "").replace(".jpg",""));// 문자열의 경로와 확장자명을 지움.
				
			}
		});
		btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 49));
		btnPrev.setBounds(48, 287, 105, 38);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
//		btnNext.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//TODO 다음 이미지 보여주기: 1 -> 2 -> 3 -> 4 -> 5 -> 1
//				if (curIndex == IMAGES.length -1) {
//					curIndex = 0;
//				} else {
//					curIndex++;
//				}
//				lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
//			}
//		});
		
		// 람다 표현식을 사용한 이벤트 리스너 등록
		btnNext.addActionListener((e) -> { // addAction... 메서드의 파라미터 e
			if (curIndex == IMAGES.length - 1) { //마지막 인덱스인 경우,
				curIndex = 0; // 처음 인덱스로 이동.
			} else { // 마지막 인덱스가 아닌 경우,
				curIndex++; // 인덱스 증가
			}
			lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
			lblImageName.setText(IMAGES[curIndex].replace("images/", "").replace(".jpg","")); // 문자열의 경로와 확장자명을 지움.
		});
		
		
		btnNext.setFont(new Font("D2Coding", Font.PLAIN, 49));
		btnNext.setBounds(221, 287, 105, 38);
		frame.getContentPane().add(btnNext);
		
		lblImageName = new JLabel(IMAGES[curIndex].replace("images/", "").replace(".jpg",""));// 문자열의 경로와 확장자명을 지움.
		lblImageName.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblImageName.setBounds(12, 223, 360, 27);
		frame.getContentPane().add(lblImageName);
	}

}
