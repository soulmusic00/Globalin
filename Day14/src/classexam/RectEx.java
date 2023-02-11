package classexam;

public class RectEx {

	public static void main(String[] args) {

		Rect r; // 객체선언(참조변수)
		r = new Rect(); // 객체 생성

		// 입력
		r.input();
		// area() 메서드 호출하고 결과를 리턴 받아서 area라는 변수에 저장한다.

		/// 계산
		int area = r.area();

		int length = r.length();

		// 출력
		r.output(area, length);

//		System.out.println("사각형의 넓이는: " + area);
//		System.out.println("사각형의 둘레는: " + length);
	}

}
