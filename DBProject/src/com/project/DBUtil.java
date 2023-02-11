package com.project;

import java.sql.*;

public class DBUtil {

	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static final String id = "scott";
	static final String password = "tiger";

	public static Connection getConnection() throws Exception {

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, password);

//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String id = "scott";
//		String password = "tiger";

		return con;

	}

	public static void main(String[] args) {

		Connection con = null;
		try {

			con = DBUtil.getConnection();
			System.out.println("데이터 베이스 연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}
	}

	}

//	public static Connection getConnection() {
//
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String id = "scott";
//		String password = "tiger";
//
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url, id, password);
//		} catch (SQLException ss) {
//			ss.printStackTrace();
//		}
//		return conn;
//	}


