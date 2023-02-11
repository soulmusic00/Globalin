package com.absex;

public class InterfaceEx implements interEx {

	@Override
	public int getA() {
		// TODO Auto-generated method stub
		return A;
	}
	
	public static void main(String[] args) {
		InterfaceEx ie = new InterfaceEx();
		
		System.out.println(ie.getA());
		
		
	}

}
