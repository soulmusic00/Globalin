package com.dbex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx06 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// 동적 쿼리문 작성
		String sql = "update professor set sal=? where name = ?";

		try {
			conn = ConnUtil.getConnection();

			pstmt = conn.prepareStatement(sql);

			// 바인딩 변수 설정
			pstmt.setInt(1, 500);
			pstmt.setString(2, "홍길동");

			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정 되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

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
