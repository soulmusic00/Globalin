package classexam;

public class Tv { // 클래스의 정의(설계도)

	// 멤버필드(속성, 변수)
	// 색상
	String color;
	// 전원상태
	boolean power;
	// 채널
	int channel;

	// 기능, 행위, 동작(메소드)
	// Tv를 켜거나 끄는 기능을 메소드로 정의
	public void power() {

		power = !power;
		System.out.println(power);
	}

	public void channelUp() { // 채널을 올리는 기능
		++channel;
	}

	public void channelDown() { // 채널을 내리는 기능
		--channel;
	}

	public static void main(String[] args) {

		Tv tv = new Tv();

		tv.power = true;
//		tv.power = false;

		tv.power();

	}

}
