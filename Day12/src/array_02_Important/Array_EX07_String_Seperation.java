package array_02_Important;

/*		문]
 *		입력받은 인원 수 만큼 학생의 이름과 전화번호를 입력받고 
 *		입력 받은 내용을 전체 출력하는 프로그램을 작성
 *
 * 		단, 배열을 활용하시오
 * 
 * 		입력 처리할 학생 수 : 3
 * 		이름 전화번호 입력(1)[공백구분] : 홍길동 010-1111-1111
 * 		이름 전화번호 입력(2)[공백구분] : 이순신 010-4444-2222
 * 		이름 전화번호 입력(3)[공백구분] : 강감찬 010-3333-3333
 * 		===============================
 * 
 * 		전체 학생수 : 3
 * 		-----------------------------
 * 		이름     전화번호
 * 		홍길동  010-1111-1111
 * 		이순신  010-2222-2222
 * 		강감찬  010-3333-3333
 * 
 */

import java.util.*;

public class Array_EX07_String_Seperation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 처리 할 학생 수 : ");
		int n = sc.nextInt();
		
		//학생 이름을 저장할 변수
		String[] name = new String[n];
		//학생 전화번호를 저장할 변수
		String[] phone = new String[n];
		
		for(int i=0;i<name.length;i++) {
			System.out.println("이름    전화번호 입력 ("+(i+1)+") [공백으로 구분] : ");
			name[i] = sc.next();	// next()는 공백으로 구분! 
			phone[i] = sc.next();	// 즉 next()는 이름과 전화번호를 각각의 배열에 들어가는 입력을 공백으로 구분!
		}
		System.out.println();
		System.out.println("================");
		System.out.println("전체 학생 수 : "+n+" 명");
		System.out.println("-----------------------------");
		System.out.println("  이름         전화번호");
		for(int i = 0;i<name.length;i++) {
			System.out.println(name[i]+"\t\t"+phone[i]);		
		}
		System.out.println("-----------------------------");
	}
}
