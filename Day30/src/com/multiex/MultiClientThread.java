package com.multiex;


import java.io.*;
import java.net.*;


public class MultiClientThread extends Thread {
	
	
	
	// 여기에서는 수신만 해줌 
	private BufferedReader in; //입력 

	//생성자 초기화
	public MultiClientThread (BufferedReader in) {
		
		this.in= in;
		
	}

	
	
	@Override
	public void run() {
		
		
		try {
			
			while(true) {
				String text = in.readLine();
				System.out.println("수신 메세지: "+text);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	
	

}
