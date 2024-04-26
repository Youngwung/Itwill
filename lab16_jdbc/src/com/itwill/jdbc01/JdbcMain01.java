package com.itwill.jdbc01;

import static com.itwill.jdbc.OracleJdbc.*;
// URL, USER, PASSWORD 상수를 가져옴.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.itwill.model.Blog;
import com.itwill.model.Blog.Entity;

import oracle.jdbc.OracleDriver;

import static com.itwill.model.Blog.Entity.*;

/*
 * JDVBC(Java Database Connectivity)
 * 자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행해서 그 결과를 처리.
 * 
 * 1. Oracle JDBC 라이브러리를 다운로드하고 이클립스 프로젝트의 빌드패스에 추가.
 * 		(1) central.sonatype.com (메이븐 중앙 저장소)에서 ojdbc11을 검색
 * 			---->com.oracle.database.jdbc:ojdbc11:23.3.x.x.x 라이브러리를 다운로드.
 * 			----> ojdbc11-23.3.0.x.x.jar
 * 		(2) 이클립스 프로젝트에 lib폴더를 만들고, jar 파일을 복사.
 * 		(3) jar 파일을 우클릭 -> Build path -> Add to build path 선택.
 * 		-- 위 과정은 프로젝트 중 한 번만 하면 됨.
 * 
 * 2. 데이터베이스에 접속하기 위한 정보들(URL, USER, PASSWORD, ...)을 상수로 정의
 * 3. 프로그램에서 오라클 JDBC 라이브러리를 메모리에 로딩. => 코드 한 줄.
 * 4. 오라클 데이터베이스에 접속.
 * 5. Statement 타입의 객체 생성 - DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체
 * 6. Statement 타입 인스턴스에서 메서드를 호출해서 SQL 문장을 실행.
 * 		(1) executeQuery(): DQL(select 문장)
 * 		(2) executeUpdate() DML(insert, update, delete 문장)
 * 7. 메서드 실행 결과(리턴 값)을 처리.
 * 8. 사용했었던 모든 리소스들을 해제(close() 메서드 호출).
 */

public class JdbcMain01 {

	public static void main(String[] args) throws SQLException {
		
		// 테이블 만들기는 sql developer 로 할거임!!
		
		/*
		 * blogs 테이블 설계
		 * - title  - contetnt
		 * - created_date, -modified_date(수정일)
		 * - writer
		 * - id (PK, 다른 글 임을 구별하기 위한 고유 키) 
		 * 
		 * 
-------------------sql developer에서 작성한 코드-----------------------

create table blogs (
-- PK를 설정할 때 테이블 생성 시 자동으로 중복되지않고 null이 들어가지 않도록 설정해 줄 수 있음. 
-- 데이터베이스 마다 문법이 다름.
    id              number(6) generated always as identity,
    title           varchar2(100 char) not null,
    content         varchar2(1000 char) not null,
    writer          varchar2(100 char) not null,
    created_time    timestamp default systimestamp, 
    modified_time   timestamp default systimestamp,
    constraint blogs_pk primary key(id)
);

insert into blogs (title, content, writer)
values ('안녕하세요', '첫번째 블로그 테스트', 'admin');

insert into blogs (title, content, writer)
values ('teset', '두번째 블로그 테스트', 'guest');

select * from blogs;
commit;

		 */
		
		
//----------------------------------------------------------------------------
		// 이클립스에서 select 문장 실행 & 결과 출력.
		
		// 3. 오라클 JDBC 라이브러리를 사용할 수 있도록 등록.
		DriverManager.registerDriver(new OracleDriver()); // sql익셉션 발생 가능.
		// 어떤 DB에 접속하는지 알려주기 위해서 등록해야함.
		// mysql인지 디비버인지 어떤건지 알려줘야함.
		System.out.println("오라클 드라이버 등록 성공");
		
		// 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); // sql 익셉션 발생 가능.
		System.out.println("오라클 접속 성공");
		
		// 5. Statement 타입 객체 생성(Statement를 상속받는 PreparedStatement 객체 생성)
		final String sql = "select * from blogs order by id desc";
			//-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
		PreparedStatement stmt = conn.prepareStatement(sql); // sql 익셉션 발생 가능.
		
		// 6-7. SQL 문장 실행 & 결과 처리
		ResultSet rs = stmt.executeQuery(); // sql 익셉션 발생 가능.
		while (rs.next()) { // ResultSet(테이블을 담고있는 객체)에서 다음 행(row)이 있는 지 검사
			// 다음 행이 있으면 true, 없으면 false를 리턴. 
			// ===> 처음에는 0번 째 행이고, 호출할 때 마다 한 행 씩 내려감.
			
			// 그 행의 컬럼들에 있는 값을 읽음:
			int id = rs.getInt(COL_ID); // id 컬럼 값을 읽음.
			String title = rs.getString(COL_TITLE); // 테이블의 title 컬럼 값을 읽음
			String content = rs.getString(COL_CONTENT); // 테이블의 content 컬럼 값을 읽음
			String writer = rs.getString(COL_WRITER);
			LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
			LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();
			
			Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);
			System.out.println(blog);
		}
		
		// 8. DB 관련 리소스(Connection, Statement, ResultSet) 해제.
		// 리소스를 해제할 때는 리소스가 생성된 순서의 반대로 해야함.
		rs.close(); 
		stmt.close();
		conn.close(); // 오라클 접속 끊기. sql 익셉션 발생 가능
		System.out.println("오라클 접속 해제");
		
		
	}

}
