package com.collec;

public class VectorEx01 {

	
	public static void main(String[] args) {
		
		MyVector mv = new MyVector();
		
		
		int d = 5;
		float r = 3.14f;
		char[] letters = {'J','A','V','A'};
		String s = new String("Hello Java");
//		String s[] = {"Hello Java"};
		
		
		mv.addInt(d);

		mv.addFloat(r);
		
		mv.addCharArray(letters);
		
		
		
		mv.addString(s);
		
		mv.write();
	}
	
	
	
	
}
