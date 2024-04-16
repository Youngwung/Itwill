package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextArea resultField;
	private JButton devide;
	private JButton dot;
	private JButton minus;
	private JButton plus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel number1 = new JLabel("num1");
		number1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		number1.setHorizontalAlignment(SwingConstants.CENTER);
		number1.setBounds(12, 10, 84, 35);
		frame.getContentPane().add(number1);
		
		textNumber1 = new JTextField();
		textNumber1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textNumber1.setBounds(108, 10, 242, 35);
		frame.getContentPane().add(textNumber1);
		textNumber1.setColumns(10);
		
		JLabel number2 = new JLabel("num2");
		number2.setHorizontalAlignment(SwingConstants.CENTER);
		number2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		number2.setBounds(12, 55, 84, 35);
		frame.getContentPane().add(number2);
		
		textNumber2 = new JTextField();
		textNumber2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textNumber2.setColumns(10);
		textNumber2.setBounds(108, 55, 242, 35);
		frame.getContentPane().add(textNumber2);
		
		plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(e.getSource() == plus); // true: 이벤트를 호출한 버튼이 어떤 버튼인지 검사할 수 있음. 
//				try {
//					double num1 = Double.parseDouble(textNumber1.getText());
//					double num2 = Double.parseDouble(textNumber2.getText());
//					resultField.setText(String.format("%.2f + %.2f = %.2f", num1, num2, num1+num2));
//				} catch (NumberFormatException x) {
//					resultField.setText("입력창에는 숫자를 입력하세요.");
//					textNumber1.setText("");
//					textNumber2.setText("");
//				}
				handleButtonClick(e);
			}
		});
		plus.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		plus.setBounds(12, 100, 50, 50);
		frame.getContentPane().add(plus);
		
		minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					double num1 = Double.parseDouble(textNumber1.getText());
//					double num2 = Double.parseDouble(textNumber2.getText());
//					resultField.setText(String.format("%.2f - %.2f = %.2f", num1, num2, num1-num2));
//				} catch (NumberFormatException x) {
//					resultField.setText("입력창에는 숫자를 입력하세요.");
//					textNumber1.setText("");
//					textNumber2.setText("");
//				}
				handleButtonClick(e);
				
			}
		});
		minus.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		minus.setBounds(108, 100, 50, 50);
		frame.getContentPane().add(minus);
		
		dot = new JButton("X");
//		dot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					double num1 = Double.parseDouble(textNumber1.getText());
//					double num2 = Double.parseDouble(textNumber2.getText());
//					resultField.setText(String.format("%.2f x %.2f = %.2f", num1, num2, num1*num2));
//				} catch (NumberFormatException x) {
//					resultField.setText("입력창에는 숫자를 입력하세요.");
//					textNumber1.setText("");
//					textNumber2.setText("");
//				}
//				handleButtonClick(e);
//			}
//		});
		// ================= 람다표현식 ============================
		dot.addActionListener((e) -> handleButtonClick(e));
		
		
		dot.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		dot.setBounds(209, 100, 50, 50);
		frame.getContentPane().add(dot);
		
		devide = new JButton("÷");
//		devide.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					double num1 = Double.parseDouble(textNumber1.getText());
//					double num2 = Double.parseDouble(textNumber2.getText());
//					resultField.setText(String.format("%.2f ÷ %.2f = %.2f", num1, num2, num1/num2));
//				} catch (NumberFormatException x) {
//					resultField.setText("입력창에는 숫자를 입력하세요.");
//					textNumber1.setText("");
//					textNumber2.setText("");
//				}
//				handleButtonClick(e);
//			}
//		});
		// ================= 람다표현식 메서드 참조============================
		devide.addActionListener(this:: handleButtonClick);
//		devide.addActionListener(AppMain04.this:: handleButtonClick); 위에거랑 같음
//		같은 이유: 이 this가 사용된 코드는 initialize() 메서드가 가지고있는데
//		inintialize()메서드는 AppMain04클래스 안에 있으므로 this는 AppMain04의 생성된 객체의 주소를 가지고있음.
//		
//		AppMain04.this의 의미는 this를 사용한 메서드를 메인클래스가 가지고 있지 않은경우(ex_ 익명클래스, 람다표현식 등)
//		==> 메인클래스의 주소를 참조하고 싶은경우 사용한다. 
//		
		// this. => 클래스는 무조건 가지고 있는 키워드.
		// => 생성된 객체의 주소.
		// => this를 가지고있는 메서드를 가지고있는 클래스의 생성된 객체의 주소를 줌.
		// => 자기 자신이 가지고있는 멤버(필드, 메서드)를 호출할 수 있게 해주는 키워드.
		
		devide.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		devide.setBounds(300, 100, 50, 50);
		frame.getContentPane().add(devide);
		
		resultField = new JTextArea();
		resultField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		resultField.setBounds(12, 160, 338, 91);
		frame.getContentPane().add(resultField);
	}
	
	
	
	private void handleButtonClick(ActionEvent e) { 
		// 이벤트를 호출한 버튼이 어떤 버튼인 지 구별하는 것으로 코드를 가독성 좋게 만들 수 있음
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(textNumber1.getText());
			y = Double.parseDouble(textNumber2.getText());
		} catch (NumberFormatException ex) {
			resultField.setText("숫자를 입력해주세요..");
			return; // handleButtonClick메서드 종료. => 숫자가 아닌 문자열을 받았을 때 아래 쓸모없는 계산을 하지 않게하기 위함.
		}
		double result = 0; // 사칙연산 결과를 저장할 변수
		String operator = ""; // 사칙연산 기호(+, -, x, /)를 저장할 변수
		
		Object source = e.getSource(); // 버튼을 구별하기 위한 비교대상.
		// 클릭에 대해 반응할 액션은 버튼만 있는것이 아니기 때문에 source의 타입은 Object.
		// textfied는 클릭에 대한 반응이 깜빡거리는거, textarea도 마찬가지.
		
		if (source == plus) { // 이벤트가 발생한 소스(UI 컴포넌트)가 플러스 버튼인 경우
			result = x + y;
			operator = "+";
		} else if (source == minus) { // 마이너스 버튼인 경우
			result = x - y;
			operator = "-";
			
		} else if (source == dot) { // 곱하기 버튼인 경우
			result = x * y;
			operator = "x";
			
		} else if (source == devide) { // 나누기 버튼인 경우
			result = x / y;
			operator = "/";
		}
		String msg = String.format("%.2f %s %.2f = %.2f ", x, operator,y,result); //결과 창에 보여줄 문자열
		resultField.setText(msg);
		
		
	}
}
