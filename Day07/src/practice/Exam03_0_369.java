package practice;

/*
 *	문]
 * 369 프로그램을 작성하시오
 * 1~99까지 정수를 입력받고 정수의 3,6,9 중 하나가 있을 경우 "박수 짝!" 
 * 두개가 있는 경우 박수 짝!짝!을 출력하는 프로그램을 작성하시오.
 * ex) 13인 경우 박수 짝!  //  36 인 경우 박수 짝! 짝!
 * 
 *  출력형식
 *  
 *  1~99 사이의 정수를 입력하시오 >> 36
 *  박수 짝! 짝! 
 *  
 */

import java.util.*;

public class Exam03_0_369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1~99 사이의 정수를 입력하시오 >>");
		int num = sc.nextInt();

		if (num >= 1 && num < 100) {
			System.out.println(num);
			if((num / 10 == 3||num / 10 == 6||num / 10 == 9)&& (num % 10 == 3 || num % 10 == 6 || num % 10 == 9))  {
				System.out.println("박수 짝짝!");
			} else if ((num / 10 == 3||num / 10 == 6||num / 10 == 9)|| (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)) {
				System.out.println("박수 짝!");
			}
			else
				System.out.println("박수가 없습니다.");
		}
		else
			System.out.println("입력 범위를 벗어났습니다.");
		
	}
}
