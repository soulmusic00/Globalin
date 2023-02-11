
package com.collec;

import java.util.*;

public class StackEx {// stack사용시 import util해야댐
	private static final String colors[] = { "검정", "노랑", "녹색", "청색", "빨강", "연두" };

	public StackEx() {
		// 스택 객체 생성
		Stack<String> st = new Stack<>();

		for (String color : colors)
			st.push(color);
		popStack(st);
	}

	public void popStack(Stack<String> st) {
		System.out.println("pop");
		while (!st.empty()) {
			System.out.print(st.pop());
		}
	}

	public static void main(String[] args) {
		new StackEx();
		
	
	}
}