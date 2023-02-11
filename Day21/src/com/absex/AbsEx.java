package com.absex;

public class AbsEx extends AbsEx02{

	public static void main(String[] args) {
		
		AbsEx ae = new AbsEx();
//		ae.getA();
		System.out.println(ae.getA());
		System.out.println(ae.getStr());
		
		
		
	}
	
	@Override
	public String getStr() { //AbsEx2의 추상 매소드 재정의
		// TODO Auto-generated method stub
		return str;  //멤버변수는 AbsEx01
	}
	
	

}
