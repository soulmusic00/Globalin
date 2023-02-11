package com.project;

    /*
     * 
     * vo 클래스
     *  -데이터를 담는 컨테이너 역할을 하는 클래스
     *  데이터 전달을 목적으로 만들어진 클래스
     *  입출력 정보를 전달하는 역할을 수행한다.
     *  속성(필드), setter, getter로 구성되어 있다.
     * 
     * 
     */





public class EmployeeVo {

	
	private int no;
	private String name;
	private String jobGrade;
	private int department;
	private String email;
	private String status;

	public EmployeeVo(int no, String name, String jobGrade, int department, String email) {
		this.no = no;
		this.name = name;
		this.jobGrade = jobGrade;
		this.department = department;
		this.email = email;
	}

	public EmployeeVo(int no, String name, String jobGrade, int department, String email, String status) {
		this.no = no;
		this.name = name;
		this.jobGrade = jobGrade;
		this.department = department;
		this.email = email;
		this.status = status;

	}

	public EmployeeVo() {
	
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobGrade() {
		return jobGrade;
	}

	public void setJobGrade(String jobGrade) {
		this.jobGrade = jobGrade;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNo() + "," + getName();
	}
	
	
	
	
	
	
	
	

}
