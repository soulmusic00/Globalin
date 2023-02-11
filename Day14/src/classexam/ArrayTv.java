package classexam;

 /*
  * int aa; 전역(인스턴스 변수)
  * static int b; (클래스 변수(공유변수)) 객체 생성 없이 접근 가능
  * 
  */


public class ArrayTv {

	public static void main(String[] args) {

		Tv[] tv = new Tv[3];

		Tv[] tv2 = { new Tv(), new Tv(), new Tv() };

//		Tv[0] = new Tv();
//		Tv[1] = new Tv();
//		Tv[2] = new Tv();

		for (int i = 0; i < tv.length; i++) {
			tv[i] = new Tv();
			tv[i].channel = 1;
			tv[i].channelUp();
		}

		
		for(int i = 0; i < tv.length; i++) {
			tv[i].channelUp();
			System.out.println(tv[i].channel);
		}
		
		
		
		
		
	}

}
