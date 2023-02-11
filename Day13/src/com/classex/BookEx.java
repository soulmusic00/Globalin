package com.classex;

public class BookEx {

	
	 //생성자 반환명 메서드명
	public void Book() { // 인스턴스 메소드

		Book myBook;
		myBook = new Book();

		myBook.name = "자바의 정석";
		myBook.price = 500;
		System.out.println("책 제목은" + myBook.name + "이고, 책 가격은 " + myBook.price);

	}

	public static void main(String[] args) {

//		
//		// 책 객체 선언
//		Book myBook;
//		
//		//객체생성
//		myBook = new Book();
//	

		// 객체 생성
		BookEx be = new BookEx();

		// 인스턴트 메소드 호출
		be.Book();

	}

}
