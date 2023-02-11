package com.dbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbxEx04 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		
		ResultSet rs = null;
		/*
		 * 
		 * select 문으로 실행한 결과를 저장한 집합체 
		 * 데이터를 추출할 수 있는 메소드를 가지고 있는 객체가 ResultSet 
		 * 
		 * 
		 * 
		 */
		
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
			String sql = "select deptno, dname, college, loc from department";
			
			rs = stmt.executeQuery(sql);
			
			
			/*
			 * rs 객체로 부터 데이터를 추출함
			 * rs 의 next() 메소드는 커서를 다음해으로 이동시킴 
			 * 이동된 위치에 행이 존재하면 true, 존재하지 않으면 false를 반환한다. 
			 * rs.next() 이 값이 참인동안 rs로 부터 데이터를 추출함 
			 * 
			 * 
			 */
			
			while(rs.next()) {
				// 커서가 위치한 로우(행)의 각각을 열 (컬럼)에서 값을 추출함 
				// getXXX(컬럼의 위치), getXXX(컬럼이름)을 사용해서 열값을 추출함 
				int  i = rs.getInt(1);     // int i = rs.getInt("deptno");
				String s1 = rs.getString(2); // String s1 = rs.getString("dname");
				int j = rs.getInt("college"); // rs.getInt("deptno");
				String s2 = rs.getString("loc"); // rs.getString("dname"):
				System.out.println(i + "\t" + s1 + "\t" + j + "\t" + s2);
			}
			
			
			
			//쿼리문을 실행해서 결과를 저장 (5단계)
			int result = stmt.executeUpdate(sql);
			
//			System.out.println(result + " 개의 행이 추가 되었습니다 ");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			
			
			try {
				if(rs != null) rs.close();
			}catch(SQLException ss) {
				ss.printStackTrace();
			}
			
			
			
			
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
