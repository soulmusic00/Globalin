

package classexam;

import java.io.*;

/*
 * 임의의 정수를 입력받아
 * 1부터 입력받은 수까지의 합계
 * 
 * 단, 클래스를 세분화하여 처리한다.
 * 또한 입력 처리는 BufferedReader로 처리한다.
 * 입력 데이터가 1보다 작거나 100보다 큰 경우 다시 입력받도록 처리한다.
 * 
 * 
 * 
 * 
 */


public class Hap {
	
	int n;  //전역 변수 선언
	
	
	//입력기능
	void input() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("임의의 정수를 입력하세요");
			n = Integer.parseInt(br.readLine());
		}while(1 > n || n >100);
	
	}
	
	//계산 기능
	int calculate() {
		
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		
		return sum;
		
		
	}
	
	
	void prt(int hap) { //매개변수로 넘겨 받아서 처리함
		
		System.out.println("1부터 " + n + "까지의 합계:" + hap);
		
	}
}
	
