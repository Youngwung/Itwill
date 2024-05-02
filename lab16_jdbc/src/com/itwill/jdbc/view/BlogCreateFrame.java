package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogCreateFrame extends JFrame {
	
	public interface CreateNotify{
		void notifyCreateSuccess();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BlogDao dao = BlogDao.getInstance();
	private CreateNotify app;
	
	private Component parent;
	private JLabel lblTitle;
	private JTextField textTitle;
	private JLabel lblContent;
	private JTextArea textContent;
	private JScrollPane scrollPane;
	private JTextField textWriter;
	private JLabel lblWriter;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void showBlogCreateFrame(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogCreateFrame frame = new BlogCreateFrame(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BlogCreateFrame(Component parent, CreateNotify app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("새 글 작성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX(); // 부모 컴포넌트의 x좌표
			y = parent.getY(); // 부모 컴포넌트의 y좌표
		}
		setBounds(x, y, 450, 562);
		
		if (parent == null ) {
			setLocationRelativeTo(null); // 화면 중앙에 JFrame을 띄움
		}
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblTitle.setBounds(12, 10, 410, 41);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textTitle.setBounds(12, 61, 410, 41);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		lblContent = new JLabel("내용");
		lblContent.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblContent.setBounds(12, 112, 410, 41);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 151, 410, 187);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		scrollPane.setViewportView(textContent);
		
		lblWriter = new JLabel("작성자");
		lblWriter.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblWriter.setBounds(12, 348, 410, 41);
		contentPane.add(lblWriter);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textWriter.setColumns(10);
		textWriter.setBounds(12, 399, 410, 41);
		contentPane.add(textWriter);
		
		btnSave = new JButton("작성 완료");
		btnSave.addActionListener((e) -> createNewBlog());
		btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnSave.setBounds(12, 460, 174, 41);
		contentPane.add(btnSave);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnCancle.setBounds(248, 460, 174, 41);
		contentPane.add(btnCancle);
	}

	private void createNewBlog() {
		// 제목, 내용, 작성자에 입력된 내용을 Blog 객체로 만들어서
		// Dad 메서드를 사용해서 DB 테이블에 insert
		String title = textTitle.getText();
		String content = textContent.getText();
		String writer = textWriter.getText();
		if(title.equals("")||content.equals("")||writer.equals("")) {
			JOptionPane.showMessageDialog(
					BlogCreateFrame.this,
					"제목, 내용, 작성자는 반드시 입력해야 합니다!", 
					"경고", 
					JOptionPane.WARNING_MESSAGE
					);
			return; // 메서드 종료
		}
		Blog blog = new Blog(0, title, content, writer, null, null);
		int result = dao.create(blog);
		if (result == 1) {// create에 성공했을 때, (insert에 성공했을 때)
			// TODO: BlogMain 프레임에게 테이블 삽입 성공을 알려줌.
			app.notifyCreateSuccess();
			dispose();
		} else {
			JOptionPane.showInternalMessageDialog(BlogCreateFrame.this, "insert 실패.");
		}
	}
}
