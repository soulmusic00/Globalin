package com.dbex;

/*
 *  1단계  
 *  	import java.sql.*;
 *  
 *  2단계 
 * 		특정 드라이버 검색 
 * 		orccle : thin Driver 사용 
 * 			oracle.jdbc.driver.OracleDriver
 * 		Class.forName(oracle.jdbc.driver.OracleDriver)
 * 
 *  3단계                                                  scott tiger 
 *  	Connection conn = DriverManager.getConnection(url, id, password);
 *  	url, jdbc:oracle:thin:@localhost:1521:sid(orcl) 
 *  	id, : scott
 *  	password : tiger
 * 
 * 	4단계 : Query 문 작성
 *		 
 *      정적
 *      Statement Class(정적 클래스) 
 *      Statement stmt = conn.createStatemnet();
 *      
 *      동적 (게시판 만들때) - 공간만 만들때  
 * 		PreparedStatement Class(동적 클래스) 
 * 		PreparedStatement pstmt - com.prepareStatement(query)
 * 
 *  5단계 : 결과를 저장한다. 
 *  	
 *  	정적 
 *  	ResultSet rs = stmt.excuteQuery(query)  // select 
 *  	ResultSet rs = stmt.UpdateQuery(query)  // insert, update, delete 
 * 		
 *  	동적 
 * 		ResultSet rs = pstmt.excuteQuery(query)  // select 
 *  	ResultSet rs = pstmt.UpdateQuery(query)  // insert, update, delete 
 *  	
 * 
 *  6단계 
 *  	사용후 반드시 close() 한다. 
 * 
 */

import java.sql.*;  // 1단계

public class JdbcEx01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
			
		try {
			// jdbc 드라이버 메모리에 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); //2단계 
			
			//3단계 
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, id, password);
			
			
			/*
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			*/
			
			//System.out.println("데이터베이스 연결 성공 ");
			
			//statement 객체 생성 
			stmt = conn.createStatement();
			 
			//쿼리문 작성
			String sql = "insert into department values(203,'제어계측공학과', 200, '7호관')";
			
			//쿼리문을 실행해서 결과를 저장 (5단계)
			int result = stmt.executeUpdate(sql);
			
			System.out.println(result + " 개의 행이 추가 되었습니다 ");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			
			try {
				if(conn != null) conn.close();
			}catch(SQLException ss) {
				ss.printStackTrace();
			}
			
			try {
				if(stmt != null) stmt.close();
			}catch(SQLException ss) {
				ss.printStackTrace();
			}
			
			
			
		}
		
					
		
		
		
	}

}
