package com.objectex;

import java.util.Scanner;

/*
 * 문]
 * 
 * 		필드 구성
 * 			제목: title, 가수: artist, 노래발표년도 : year, 국적 : country
 * 
 *     생성자 2개로 구성 : 기본생성자, 모든 필드를 초기화
 *     노래의 정보를 출력하는 메소드: show();
 *     
 *     
 *     객체 생성하여 노래 정보를 출력하는 프로그램을 작성하시오
 * 
 * 		출력
 *     1978년 스웨덴 국적의 ABBA가 부른 Dancing Queen
 * 
 * 
 */

public class Song {

	private String title;
	private String artist;
	private int year;
	private String country;

	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(String title, String artist, int  year, String country) {

		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;

	}

	public void show() {

		System.out.println(year + "년");
		System.out.println(country + "국적의");
		System.out.println(artist + "가 부른");
		System.out.println(title);

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Song s = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");

//		System.out.println("타이틀");
//		String title = scan.next();
//		System.out.println("아티스트");
//		String artist = scan.next();
//		System.out.println("년도");
//		String year = scan.next();
//		System.out.println("나라");
//		String country = scan.next();

		s.show();

	}

}
