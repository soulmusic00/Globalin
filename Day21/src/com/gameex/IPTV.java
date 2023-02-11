package com.gameex;

import java.util.*;



public class IPTV extends ColorTv{
	
	private String ipAddr;
	
	public IPTV(String ipAddr, int size, int Color) {
		super(size, Color);
		this.ipAddr = ipAddr;
	}
	

	public void prt() {
		
		System.out.println("나의 IPTV는" + ipAddr + "주소의");
		super.prt();
		
	}
	public static void main(String[] args) {
		
	
		
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		iptv.prt();
		

	}

		
	
	
}
