package com.classex;

public class ClassEx01 {

		int a; //전역변수
	
	
	
	public static void main(String[] args) {
		
		
		ClassEx01 ce = new ClassEx01();
		//객체 생성  또는 인스턴트 생성
		
		//메서드 안에 선언한 변수를 지역변수
		//지역변수는 초기화 과정을 거치지 않으면 사용할 수 없다.
		//(자동 초기화 기능을 지원하지 않는다.)
//		int a;
//     인스턴스를 생성해야지만 인스턴스 변수에 접근 가능
		System.out.println("a: " +ce.a); 
		//초기화를 지원하지 않기 때문에 
		//초기화를 해야만 사용할 수 있다.
		//초기화의 감지는 컴파일러가 감지 하여 오류를 발생시킴

	}

}
