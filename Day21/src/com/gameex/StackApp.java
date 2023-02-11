package com.gameex;

import java.util.*;



public class StackApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("총 스택 저장 공간의 크기");
		int n = sc.nextInt();
		
		StringStack ss = new StringStack(n);
		
		while(true) {
			System.out.println("문자열 입력: ");
			String str = sc.next();
			if(str.equals("그만")) 
				break;
			
			boolean res = ss.push(str); //stack에 저장이 성공하면 true
			
			if(res == false) {
				System.out.println("스택이 꽉차서리 못들어감");
			}
			
		}
		
		//출력
		
		System.out.println("스택에 저장된 문자열 팝: ");
		
		int len = ss.length(); //현재 스택에 저장된 개수를 의마함
		for(int i = 0; i < len; i++) { //스택에 저장된 개수만큼 반복
			System.out.println(ss.pop() + " ");
		}
		
		
	}

}
