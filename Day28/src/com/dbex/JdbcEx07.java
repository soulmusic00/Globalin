package com.dbex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcEx07 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		// 동적 쿼리문 작성
		String sql = "select a.name, a.profno, a.position, b.dname\r\n" + 
					"from professor a, department b\r\n"
				+ "where a.deptno = b.deptno and a.deptno = ?";

		try {
			conn = ConnUtil.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, 203);

			rs = pstmt.executeQuery();

			// 결과추출
			while (rs.next()) {

				String s1 = rs.getString("name");
				int i = rs.getInt("profno");
				String s2 = rs.getString("position");
				String s3 = rs.getString("dname");

				System.out.println(s1 + "\t" + i + "\t" + s2 + "\t" + s3);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}

	}

}
