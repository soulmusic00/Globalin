package com.gameex;

public interface Stack {

	int length(); // 현재 Stack에 저장된 개수를 리턴

	int capacity(); // 스택 전체 저장 가능한 개수를 리턴

	String pop(); // 스택의 톱에(top) 실 제수 저장

	boolean push(String val); // 스택의 톱에 저장된 실제 수 리턴

	// Stack 인터페이스를 상속받아 실제 수를 저장하는 StringStack 클래스를 구현 하시오
	// 실행은 StackApp 클래스에 main() 메소드에 작성하여 실행

	// 총 스택 저장 공간의 크기를 입력: 3
	// 문자열 입력: hello
	// 문자열 입력: world
	// 문자열 입력: java
	// 문자열 입력: happy
	//스태기 꽉차서리 못들어감
	//문자열 입력 : 그만
	// 스택에 저장된 문자열 팝: java - world - hello

}