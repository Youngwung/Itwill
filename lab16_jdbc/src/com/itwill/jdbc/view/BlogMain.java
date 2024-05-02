package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;
import com.itwill.jdbc.view.BlogDetailsFrame.UpdateNotify;
import com.itwill.model.Blog;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BlogMain implements CreateNotify, UpdateNotify{
	private static final String[] SEARCH_TYPES = {"제목", "내용", "제목+내용", "작성자"};
	private static final String[] COLUMN_NAMES = {"번호", "제목", "작성자", "수정시간"};
	
	BlogDao dao = BlogDao.getInstance();
	
	private JFrame frame;
	private JPanel searchPanel;
	private JComboBox<String> comboBox;
	private JTextField textSearchKeyword;
	private JButton btnSearch;
	private JButton btnReadAll;
	private JButton btnCreate;
	private JButton btnDetails;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogMain window = new BlogMain();
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
	public BlogMain() {
		initialize();
		initializeTable();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("블로그 메인");
		
		
		searchPanel = new JPanel();
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
		
		comboBox = new JComboBox<>();
		final DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(SEARCH_TYPES);
		comboBox.setModel(comboBoxModel);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchPanel.add(comboBox);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> search());
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchPanel.add(btnSearch);
		
		JPanel btnPanel = new JPanel();
		frame.getContentPane().add(btnPanel, BorderLayout.SOUTH);
		
		btnReadAll = new JButton("목록보기");
		btnReadAll.addActionListener((e) -> initializeTable());
		btnReadAll.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnPanel.add(btnReadAll);
		
		btnCreate = new JButton("새 글 작성");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 새 글 작성 창 띄우기.
				BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this);
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnPanel.add(btnCreate);
		
		btnDetails = new JButton("상세보기");
		btnDetails.addActionListener((e) -> showDetailsFrame());
		btnDetails.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnPanel.add(btnDetails);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deleteBlog());
		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnPanel.add(btnDelete);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
	}
	
	private void showDetailsFrame() {
        int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
        if (index == -1) { // JTable에서 선택된 행이 없을 때
            JOptionPane.showMessageDialog(
                    frame, 
                    "상세보기할 행을 먼저 선택하세요.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Integer id = (Integer) tableModel.getValueAt(index, 0);
        
        BlogDetailsFrame.showBlogDetailsFrame(frame, id, BlogMain.this);
        
    }
	
	private void search() {
		int type = comboBox.getSelectedIndex();
		String keyword = textSearchKeyword.getText();
		if (keyword.equals("")) { // 검색어 입력이 안되었을 때.
			JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			textSearchKeyword.requestFocus();
			// -> 검색어 입력 JTextField에 포커스를 줌 (커서 깜박깜박).
			return; // 메서드 종료.
		}
		// dao 메서드를 호출해서 검색 결과를 가져옴.
		List<Blog> blogs = dao.search(type, keyword);
		resetTable(blogs);
	}
	
	private void deleteBlog() {
		int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
		if (index == -1) { // JTable에서 선택된 행이 없을 때
			JOptionPane.showMessageDialog( // 경고 메세지 출력.
					frame,
					"삭제할 행을 먼저 선택하세요.", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			
			return; // 메서드 종료
		}
		int confirm = JOptionPane.showConfirmDialog(
				frame,
				"정말 삭제하시겠습니까?", 
				"삭제",
				JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			// 선택된 행에서 블로그 번호(id)를 읽음.
			Integer id = (Integer) tableModel.getValueAt(index, 0); // 까먹기 쉬울듯
			// id로 Dao의 delete() 메서드 호출
			int result = dao.delete(id);
			if (result == 1) {
				initializeTable();
				JOptionPane.showMessageDialog(frame, "삭제 성공!");
			} else {
				JOptionPane.showMessageDialog(frame, "삭제 실패");
				
			}
		}
		
	}
	
	private void resetTable(List<Blog> blogs) {
		// 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		
		for (Blog b : blogs) {
			// DB 테이블에서 검색한 레코드를 JTable에서 사용할 행(row) 데이터로 변환.
			Object[] row = {
					b.getId(), b.getTitle(),
					b.getWriter(), b.getModifiedTime()
			};
			tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
		}
		table.setModel(tableModel); // JTable의 모델을 다시 세팅(보여주기)
	}
	

	private void initializeTable() {
		// DAO를 사용해서 DB 테이블에서 검색.
		List<Blog> blogs = dao.read();
		
//		// 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
//		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
//		
//		for (Blog b : blogs) {
//			// DB 테이블에서 검색한 레코드를 JTable에서 사용할 행(row) 데이터로 변환.
//			Object[] row = {
//					b.getId(), b.getTitle(),
//					b.getWriter(), b.getModifiedTime()
//			};
//			tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
//		}
//		table.setModel(tableModel); // JTable의 모델을 다시 세팅(보여주기)
		resetTable(blogs);
	}

	@Override
	public void notifyCreateSuccess() {
		// 테이블에 insert 성공했을 때 BlogCreateFrame에서 호출할 메서드.
		initializeTable(); // JTable을 최신화하는 메서드
		JOptionPane.showMessageDialog(frame, "새 글 작성 성공!");
	}

    @Override
    public void notifyUpdateSuccess() {
        // 테이블에 update 성공했을 때 BlogDetailsFrame이 호출하는 메서드.
        initializeTable();
        JOptionPane.showMessageDialog(frame, "블로그 업데이트 성공!");
    }


}
