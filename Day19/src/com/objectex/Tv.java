package com.objectex;


/*
 * 
 * 문]
 *   //생성자로 초기화, 메서드를 이용하여 
 *   Lg, 2017, 65인치
 *   
 * 
 * 
 *  //출력
 *  
 * 	 LG에서 만든 2017년형 65인치 Tv
 * 
 *   manufacturer, year, size
 *   show()
 *   
 * 
 */



public class Tv {

	//필드 정의
	private  String manufacturer;
	private int year;
	private int size;
	
	//생성자
	public Tv(String manufacturer, int year, int size) {
		this.manufacturer = manufacturer;
		this.year = year;
		this.size = size;
	}
	
	
	//메소드 정의
	public void show() {
		
		System.out.println(manufacturer + "에서 만든");
		System.out.println(year + "년형");
		System.out.println(size + "인치 TV");
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Tv tv = new Tv("LG", 2017, 65);
		
		tv.show();
		
		
	}

}
