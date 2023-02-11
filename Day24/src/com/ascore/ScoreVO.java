package com.ascore;

public class ScoreVO {

	private String hak;
	private String name;
	private String birth;
	private int kor;
	private int eng;
	private int math;
	private int tot;

	public String getHak() {
		return hak;
	}

	public void setHak(String hak) {
		this.hak = hak;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getTot() {
		tot = kor + eng + math;
		return tot;
	}


	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
	//메서드
	@Override
	public String toString() {
		
		
		String str = String.format("%7s%10s%10s%5d%5d%5d%5d%6.1f", hak, name, birth, kor, eng, math , getTot(),(float)getTot()/3);
		
		return str;
	}

}
