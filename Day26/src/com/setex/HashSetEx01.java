package com.setex;

import java.util.*;

public class HashSetEx01 {

	public static void main(String[] args) {
		
		
		Object[] objArr = 
			{"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};	
		
		// 꺽새 안에는 클래스
		
		Set<Object> set = new HashSet<Object>();
		
		for(int i = 0; i<objArr.length; i++) {
			set.add(objArr[i]);
			//HashSet에 objArr의 요소들을 저장한다.
		}
		
		// HashSet에 저장된 요소들을 출력
		System.out.println(set);
	}

}
