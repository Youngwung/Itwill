package com.itwill.Dao;
import static com.itwill.jdbc.OracleJdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;
public class JdbcDao {
	public Connection conn = null;
	public PreparedStatement stmt = null;
	
	public void jdbcController(String sql) {

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
}
