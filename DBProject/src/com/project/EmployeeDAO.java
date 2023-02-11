package com.project;

/*
 * 
 *  DAO class 의 약자는 data access object 의 약자 
 *  
 *  신규 사원등록
 *  getEmployeeregiste();
 *  
 *  
 *  사원 정보조회  (번호, 이름) 
 *  getEmployeeCheck();
 *  
 *  하기 조회 시스템을 메소드로 만들 것임 
 *  사원 정보 조회 1 (번호로만)
 *  getEmployNo();
 *  
 *  사원 정보 조회 2 (이름으로만)
 *  getEmployName();
 *  
 *  
 *  전체사원보기 
 *  getEmployeeTotal(); // 전체사원이니까 목록임 
 *  
 *  
 *  
 * 
 * */
import java.sql.*; // 데이터베이스 연결
import java.util.*; // array list / 전체사원목록에서 쓸 것이기때문임

public class EmployeeDAO {

	// 새로운 사원 등록
	public EmployeeVo getEmployeeregiste(EmployeeVo evo) throws Exception {

		// 사원등록을 위한 sql문 작성
		String dml = "insert into employee (no, name, jobGrade, department, email)"
				+ "values(employee_seq.nextval,?,?,?,?)";
		// sec.nextval = 자동 시퀀스 - 1씩 증가하는 거 = sql에서 시퀀스 생성해줌

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVo retval = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, evo.getName());
			pstmt.setString(2, evo.getJobGrade());
			pstmt.setInt(3, evo.getDepartment());
			pstmt.setNString(4, evo.getEmail());

			int i = pstmt.executeUpdate();
			retval = new EmployeeVo();
			retval.setStatus(i + "");

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
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}

		return retval;

	}// end getEmployeeregiste()

// 사원정보 조회(번호)
	public EmployeeVo getEmployeeNo(int no) throws Exception {

		String dml = "select * from employee where no =?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVo retval = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery(); // select 문!이므로

			if (rs.next()) {
				retval = new EmployeeVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					// 6단계
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (pstmt != null)
					// 6단계
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (rs != null)
					// 6단계
					rs.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
		}
		return retval;
	} // end getEmployeeNo()

	// 사원의 번호로 조회하는 코드
	public EmployeeVo getEmployeeCheck(int no, String name) throws Exception {

		String dml = "select * from employee where no =? and name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVo retval = null;

		try {

			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				retval = new EmployeeVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

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
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}

		return retval;
	} // end getEmployeeNo()

	// 이름을 입력받아 검색하는 코드
	public EmployeeVo getEmployeeName(String name) throws Exception {

		String dml = "select * from employee where no =? and name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVo retval = null;

		try {

			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			// 이름이니까 setString name으로 설정
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				retval = new EmployeeVo(
						// 하기 내에 데이터있으면 해당 결과를 가져옴
						// 출력은 전부 출력하기때문에 다 검색하는 것임
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

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
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}

		return retval;
	}// end getEmployName()

	public ArrayList<EmployeeVo> getEmployeeTotal() {

		ArrayList<EmployeeVo> list = new ArrayList<EmployeeVo>();

		// 전체 사원 조회하는 data manipulation language
		String dml = "select * from employee";

		Connection con = null;
		// 동적 . 바인딩변수 활용되기때문

		// 준비된선언
		PreparedStatement pstmt = null;

		// 결과셋
		ResultSet rs = null;

		// 사원데이터 오브젝트
		EmployeeVo emVo = null;

		try {

			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 있는 거 무조건 반복해서 가져옴
				emVo = new EmployeeVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(emVo);

			}
			// 위에서 가져온 데이터를 list에 추가시킴

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}

		// 리스트로 받아서 뿌리기
		return list;

	}

	// 메소드 생성 이거 뭔 메소드지..?ㅋㅋ
	public ArrayList<String> getColumnName() {

		ArrayList<String> columnName = new ArrayList<>();

		String dml = "select * from employee";
		Connection con = null;
		// 동적 . 바인딩변수 활용되기때문
		// 준비된선언
		PreparedStatement pstmt = null;
		// 결과셋
		ResultSet rs = null;

		ResultSetMetaData rsmd = null;

		try {

			con = DBUtil.getConnection();

			pstmt = con.prepareCall(dml);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int cols = rsmd.getColumnCount();

			for (int i = 1; i <= cols; i++) {

				columnName.add(rsmd.getColumnName(i));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}

		}

		return columnName;

	}

	// 사원정보 입력화면 (라벨?)이름, 직급, 메일, 부서(콤보박스/부서번호를 선택하시오.), (버튼) 저장, (버튼) 취소버튼 = 리셋

}