package classexam;

public class LgTv {

	public static void main(String[] args) {
		
		Tv tv;   // 객체선언 ==> 인스턴스를 참조하기 위한 참조변수
		tv = new Tv();    //객채생성
		
//		Tv[] tv = new Tv[3];
//		tv  = new Tv[0];
//		tv  = new Tv[1];
//		tv  = new Tv[2];
//		tv[0] = new Tv();
//		tv[1] = new Tv();
//		tv[2] = new Tv();
//		
		
		
		tv.channel = 24;
		
		//tv 객체의 메소드를 호출함
		tv.channelDown();
		
		System.out.println("현재 Tv의 채널은" + tv.channel + "입니다.");
		
		
		
		

	}

}
