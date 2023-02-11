package classexam;

import java.io.*;
import java.util.*;

//

//   임의의 두 정수와 연산자를 입력받아 처리하는 프로그램을 구현
//   
//    	단, 클래스를 구분하여 구현하시오
//  
//  		임의의 두 정수 입력[공백 구분]; 105
// 		연산자 입력[ + - */]: +
//
//    입력기능, 연산처리 기능, 출력기능 구현
//    입력 기능은 두 가지 모두 사용하시오
//
//
//

public class Calc {

	int n1, n2;
	char ch;

	// 입력
	void input() throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("임의의 두정수 ");
		n1 = sc.nextInt();
		n1 = sc.nextInt();
		System.out.println("연산자 입력[+ - * /]:");
		ch = (char) System.in.read();
	}

	// 처리

	int cal() {

		int sum = 0;
		switch (ch) {

		case '+':
			sum = n1 + n2;
			break;
		case '-':
			sum = n1 - n2;
			break;
		case '*':
			sum = n1 * n2;
			break;
		case '/':
			sum = n1 / n2;
			break;

		}

		return sum;


	}

	void prt(int a) {

		System.out.printf("%d %c %d = %d\n", n1, ch, n2, a);

	}

}
