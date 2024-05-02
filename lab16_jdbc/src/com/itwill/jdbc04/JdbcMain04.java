package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain04 {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		final String sql = "delete from blogs where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 행을 입력하세요>> ");
		int id = Integer.parseInt(sc.nextLine());
		stmt.setInt(1, id);
		
		int result = stmt.executeUpdate();
		System.out.println(result + "개의 행 삭제 완료.");
		
		stmt.close();
		conn.close();
		
	}

}
