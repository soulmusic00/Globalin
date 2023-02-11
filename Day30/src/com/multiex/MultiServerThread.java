package com.multiex;


import java.net.*;
import java.util.ArrayList;
import java.io.*;

/*
 * 
 * 	 각각 클라와 연결된 소켓 객체를 함께 모아놓고, 접속 및 통신을 가능하게 해주는 객체 
 * 
 * 
 *  특정 클라가 전송한 메시지를 읽고, 모든 클라에게 브로드캐스팅 
 * 
 * */


// 쓰레드 구현 시에는 쓰레드 클래스 상속해야함 
public class MultiServerThread extends Thread {
	
	
		private Socket socket;
		private BufferedReader in; //입력 
		private PrintWriter out; // 출력
		
		
		// 어레이리스트 소환 = 클라리스트로 만듦 / 각각 배열에 클라의 소켓들이 저장되는 것임 
		private ArrayList<MultiServerThread>  clientList;
	
	
	//생성자
	public MultiServerThread (ArrayList<MultiServerThread>  clientList, Socket socket) {
		
		
		this.clientList = clientList;
		this.socket = socket;
		
	}
	
	
	
	// 동기화 키워드 synchoronized
	// 클라 여러명이 한꺼번에 같이 접속하면 서버가 다운된다고 함 그래서 동기화 시키기위해  synchronized 시킴 
	// (실시간으로 변동상황을 반영 시키게 됨 = 그래서 오류가 발생할 확률이 줄어드는 것)
	@Override
	public synchronized void run() {
		
		try {
			
			// 여기다가 스트림을 연결 해야함 / 인, 아웃 스트림을 만들어야함 
			//읽고 보내기 in ,  out
			
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream());
			

			
			// 클라이언트와 메시지를 반복적으로 송수신
			
			while(true) {
				
				
						// 클라가 보낸 메세지를 읽고 뿌림 
				// 전역에서 지정한 버퍼를 스트링 =  msg로 지정 
				String msg = in.readLine();
						broadcasting(msg);	
			}
			
			
			
		} catch (IOException io) {
				// 연결 끊어져서 자기자신을 제거 
				clientList.remove(this);
				// 연결이 끊어진 클라이언트 호스트의 아이피를 구해서 String에 대입시킴 = 해당 스트링을 다른 클라이언트에게 브로드캐스팅 시키기 위함임
				String ipAddress = socket.getInetAddress().getHostAddress(); // 이걸 브로드 캐스팅한 곳에 넘겨줌 
				
				
				try {
					// 다른 클라이언트에게 연결이 끊어진 클라의 퇴장 사실을 알림
					broadcasting(ipAddress+"와의 연결이 끊어짐");
					
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			}
	
	
	// 모든 클라에게 브로드캐스팅 (전체 방송) 하는 기능 
	public void broadcasting(String msg) throws IOException {
		
		// 클라이언트 리스트를 멀티서버쓰레드의 개수만큼 반복하면서 
		// 각각 멀티서버 쓰레드에 바로 하단에 센딩메세지 메소드를 호출해서 각각 클라에게 메세지를 전달하는 기능
		// 걍 메세지를 각각 클라이언트에게 전달하는 역할을 한다고 보면 됨 
		
		for (MultiServerThread t : clientList) {
			// 각각의 
			t.sendMsg(msg);
		}
		

	}
	
	// 전달받은 메세지를 아웃풋스트림과 연결된 프린트라이터를 이용해서 클라이언트에게 전달하는 기능 
	public void sendMsg(String msg) throws IOException {
			out.println(msg);
			out.flush();
	}
		}	

	
