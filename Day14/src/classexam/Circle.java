package classexam;

public class Circle {

	// 원의 반지름
	public int radius;

	// 원의 이름
	public String name;

	public Circle() {

	}

	public Circle(int r) {
		// 기본생성자 : 매개변수가 없고, 아무 일 없이 단순함
		radius = r;
		// name = "";
	}

	public Circle(int r, String n) {
		this();
		this.radius = r;
		this.name = n;

	}
//
//	/*
//	 * 생성자는 return 타입이 없다. 생성자의 목적은 필드 값을 초기화
//	 * 
//	 */
//

//	// 생성자 함수

//	
	void set(int r) {
		radius = r;

	}

	// 원의 면적을 구하는 메소드 정의
	public double getArea() {

		return 3.14 * radius * radius;

	}

}
