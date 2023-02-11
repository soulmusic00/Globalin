package com.collec;

import java.util.*;

class MyVector extends Vector {

	public MyVector() {
		//부모의 생성자 호출
			super(1, 1);

	}

	public void addInt(int i) {

		addElement(new Integer(i));

	}

	public void addFloat(float f) {
		addElement(new Float(f));
	}

	public void addCharArray(char[] a) {
		addElement(a);
	}

	public void addString(String s) {
		addElement(s);
	}

	public void write() {

		Object o;
		int length = size();

		for (int i = 0; i < length; i++) {
						  //2
			o = elementAt(i);
			if (o instanceof char[]) {
				System.out.println(String.copyValueOf((char[]) o));
			} else {
				System.out.println(o.toString());
			}

		}
	}
}
