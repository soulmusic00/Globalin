package com.inher;

public class SuperEx01 extends SuperEx {

	protected int b = 100;

	public void print() { // SuperEx01 클래스의 인스턴스 메소드

		System.out.println("SuperEx01 print() : " + super.b + ":"+ c);

	}

	@Override
	public void write(){
		System.out.println("SuperEx01 write() : " + b + ":" + c);
	}

}
