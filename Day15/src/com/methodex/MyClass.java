package com.methodex;

//생성자의 오버로딩

/*
 * 생성자
 * - 메모리 내에 객체가 생성될 때  호출되어 객체의 구초를 인식하게 하고
 *   생성되는 멤버변수들을 초기화 하는데 목적을 둠
 *   
 * - 생성자 명은 클래스명과 같아야하고 리턴 타입은 정의하지 말아야함
 * 
 * - 프로그래머가 어떻나 생성자도 정의 하지 않을 경우 컴파일러가 기본 생성자를 자동으로 정의해 준다.
 *   기본생성자(매개변수가 없는 생성자, 인자가 없는 생성자)
 *   
 *   생성자의 접근 제한자
 *   -생성자의 접근제한을 둘 경우 해당 객체를 생성할 수 있는 접근 권한을 가짐
 *   -생성자를 private로 정의 하면 클래스 내부에서만 접근이 가능함
 *   - protected로 정의 되는 클래스는 상속 관계의 객체들만 생성 가능
 *    * 생성자의 구성
 *   [접근제한자] [생성자명](자료형 인자1, 자료형 인자2, ...)
 * 	 
 *   생성자의 특징
 *   1. 클래스명과 똑같다.
 *   2. 반환형 void를 명시할 수 없다.
 *   3. 클래스 내부에 생성자가 없을 때는 컴파일러가 기본 생성자를 만든다.
 *   4. 하나의 클래스에는 인자가 다른 생성자를 여러개 가질 수 있다.(생성자 오버로딩) 
 *   5. 생성자의 첫번째 라인에서 this(인자) 사용해서 다른 생성자를 호출 할 수 있다. 
 * 
 * 
 * 
 * 
 */


public class MyClass {

	private String name;
	private int age;

	public MyClass() {
		name = "무명";

	}

	public MyClass(String n) {
		//this(); // 기본 생성자 호출
		name = n;
	}

	public MyClass(String n, int a) {
		//this(n)
		name = n;
		age = a;
	}
	
	//매개변수의 순서만 바뀌면 된다.
	public MyClass(int a, String n) {
		//this(n,a)
		name = n;
		age = a;
	}
	
	

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
