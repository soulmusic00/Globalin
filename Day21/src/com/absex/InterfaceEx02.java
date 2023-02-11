package com.absex;

interface Inter1 {
	public int getA();
}

interface Inter2 {
	public int getA();
}

interface Inter3 extends Inter1, Inter2{
	public int getData();
}






public class InterfaceEx02 implements Inter3{

	
	int a = 100;
	
	
	public static void main(String[] args) {

		
		InterfaceEx02 ife = new InterfaceEx02();		
		
		Inter1 it1 = ife;
		Inter2 it2 = ife;
		Inter3 it3 = ife;
		
		System.out.println(it1.getA());
		System.out.println(it2.getA());
		System.out.println(it3.getData());
		
		
	}

	@Override
	public int getA() {
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public int getData() {
		// TODO Auto-generated method stub
		return a+10;
	}

}


/*
 * 
 * 추상클래스와 인터페이스의 차이점 * 
 * 
 * 추상클래스는 단일 상속이다.
 * 
 * 
 * 추상 클래스와 인터페이스의 공통점
 * 
 * 인터페이스는 다중상속이 가능하다.
 * 
 *  추상클래스와 인터페이스의 공통점 *
 *  1. 객체를 생성 할 수 없다.
 *  2.상속에서 하위 클래스를 통해서 객체를 생성할 수 있다.
 *  즉, 메소드를 재정의 해야함 
 *  
 *  
 *  * 
 */





