package array_02_Important;

/*
 *   배열
 *  	    - 배열은 같은 자료형들끼리 모아 높은 하나의 묶음임.
 *      	- 자바에서 하나의 배열을 하나의 객체로 인식함.
 *   	 	- 동일한 자료형이 여러 개 반복 될 때 이를 하나의 변수명으로 관리하며,
 *    		  각각의 구분은 순차적인 첨자(인덱스)를 사용함.
 *   		- 참조 자료형의 크기 4Byte 
 *   
 *   1차원 배열
 *      배열 선언 : int[] 배열명;
 *      			   int 배열명[];
 *      배열의 초기화 : 배열명 = new 자료형[개수];
 *      			 또는 배열명 = {값1, 값2, 값3,.......n};
 *  
 *  	new에 의해서 메모리가 할당되면 자동으로 초기화한다.
 *  
 */

public class Array_EX01 {
	public static void main(String[] args) {
		// 배열 선언
		char[] ch;
		// 배열 초기화
		ch = new char[] {'J','A','V','A'}; // ch[0] = '0'/ ch[1] = '1'/ ch[2] = '2'/ ch[3] = '3'
		// 또는
/* 
 		// 배열에 값을 따로 입력
		char[] ch;
		ch = new char[4];
		ch[0] = 'J';
		ch[1] = 'A';
		ch[2] = 'V';
		ch[3] = 'A';
*/
		System.out.println(ch.length);
		for (int i = 0; i < ch.length; i++) { // ch.length = 4
			System.out.print(ch[i]);
		}
		System.out.println();
		for (char c : ch)				//처름부터 자료형을 char로 선언
			System.out.print(c);
		
				System.out.println();
		for (int c : ch) 
			System.out.print((char) c);// 강제형변환
			
				System.out.println();
		
				System.out.println("=====================");

		int[] arr = new int[10];
		// int[] 	: 배열 타입
		// arr 	: 배열에 대한 레퍼런스 변수(참조 변수)
		// new	: 배열 생성
		// int 	: 자료형을 의미함.
		// [10] 	: 배열의 개수(= 원소 개수)
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		//  1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0
		System.out.println(arr[3]);  // arr[3]에 들어있는 값을 출력
		
		for(int i = 0; i<arr.length;i++)
			System.out.printf("%4d",arr[i]);
	}
}
