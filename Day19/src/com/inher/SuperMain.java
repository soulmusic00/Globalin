package com.inher;

public class SuperMain{

	public static void main(String[] args) {

		
		SuperEx01 se = new SuperEx01();
//		se.write(); // 필드값 자식
//		se.print();  // 필드값 부모
		
		//부모의 멤버 필드에 접근 하는 방법
		
		System.out.println(((SuperEx)se).b);
		((SuperEx)se).write();
		System.out.println(se.b);
		
	
		
		
		
	}

}
