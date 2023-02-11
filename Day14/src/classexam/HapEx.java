package classexam;

import java.io.*;


public class HapEx {

	public static void main(String[] args) throws IOException {
		
		
		
		Hap h = new Hap();
		
		//입력 메서드 호출
		h.input();
		
		
		
		//계산 메서드 호출
		int hap = h.calculate();
		
		//출력 메서드 호출
		h.prt(hap);
		

	}

}
