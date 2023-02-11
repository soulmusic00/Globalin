package com.setex;
import java.util.*;
public class HashSetEx {// set에서는 중복을 허용하지않음
	public static void main(String[] args) {
		Set<String> dog = new HashSet<String>();
		dog.add("진돗개");
		dog.add("풍산개");
		dog.add("삽살이");
		System.out.println(dog);
		dog.add("진돗개");
		System.out.println(dog);
		// 중복을 허용하지 않음 => 오류는 아님
		System.out.println();
		Iterator<String> it = dog.iterator();
		while (it.hasNext()) {// 데이터가 있는지 없는지
			String s = it.next();
			System.out.print(s + " ");
		}
	}
}