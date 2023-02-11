package array_Exam;

/*	문]
 * 
 *  과목과 점수가 짝을 이루도록 2개의 배열을 작성.
 *  
 *  과목 이름을 입력받아 점수를 출력하는 프로그램을 작성하시오.
 *  종료는  "그만"을 입력하면 됨.
 * 
 * 
 */

import java.util.*;

public class Array_ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] subject = { "Java", "DataBase", "HTML", "JSP", "Spring" };
		int[] score = { 95, 88, 76, 62, 98 };

		while (true) {
			System.out.print("과목명 입력 : ");
			String name = sc.next();
			if (name.equals("그만"))
				break;
			int i;
			for(i=0;i<score.length;i++) {
				if(subject[i].equals(name)) {
					System.out.println(name+"의 점수는 "+score[i]);
				break;
				}
			}
		   // 여기서 i 값은 5
			if(i == score.length)   // 5==5  즉, 디폴트   
				System.out.println("과목명이 존재하지 않습니다. 다시 입력 하세요");
		}
	}
}
