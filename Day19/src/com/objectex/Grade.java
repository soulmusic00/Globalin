package com.objectex;

import java.util.*;

/*
 * 
 * 국어, 영어, 수학 과목 점수를 입력받아 Grade 객체를 생성하고 
 * 평균을 출력하는 프로그램을 작성
 * 필드 타입 
 * int 형  접근 변경자는 private 
 * 출력 
 * average() 메서드를 작성하여 평균을 계산
 * 
 * 국어 영어 수학 점수 입력  : 10 20 30 
 * 평균은 20 
 * 
 * 
 * 
 */

public class Grade {

	Scanner sc = new Scanner(System.in);

	private int korea;
	private int english;
	private int math;

	public Grade(int Korea, int english, int math) {

		this.korea = korea;
		this.english = english;
		this.math = math;

	}
	
	
	

//	public void input() {
//
//		System.out.println("국어");
//		korea = sc.nextInt();
//
//		System.out.println("영어");
//		english = sc.nextInt();
//
//		System.out.println("수학");
//		math = sc.nextInt();
//
//	}

	public int average() {

		return (korea + english + math) /3;
		
		
		
		
		
//		System.out.println("국어");
//		korea = sc.nextInt();
//
//		System.out.println("영어");
//		english = sc.nextInt();
//
//		System.out.println("수학");
//		math = sc.nextInt();
		
		
		
		
		
	}

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 영어 수학 점수 입력 : ");
		int korea = sc.nextInt();
		int english = sc.nextInt();
		int math = sc.nextInt();
		
		Grade gd = new Grade(korea, english, math);
		System.out.println("평균은 "  + gd.average());
	}

}
