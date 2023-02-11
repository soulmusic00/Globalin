package com.gameex;

public class ColorTv extends Tv{

	private int Color;
	
	public ColorTv(int size, int color) {
		super(size);
		this.Color = color;
	}
	
	public void prt() {
		System.out.println(getSize()+ " 인치 " + Color + "컬러");
	}
	


	public static void main(String[] args) {
		
		ColorTv ct = new ColorTv(32, 1024);
		ct.prt();
		
		
		
	}

}
