package methodex;

public class StaticMain {

	public static void main(String[] args) {
		
	//	System.out.println(StaticEx.x); //에러: 객체 생성을 해야만 접근 가능
		System.out.println(StaticEx.y);
		StaticEx.y = 100;
		System.out.println(StaticEx.y);
		
		StaticEx se = new StaticEx();
		
		System.out.println(se.x);
		System.out.println(se.y);
		
		
		
	}

}
