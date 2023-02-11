package com.multiex;


import java.net.*;
import java.io.*;
import java.util.*;


/*
 * 
 * 	 멀티 쓰레드 서버  / 채팅프로그램 / 다수의 클라가 서버를 통해서 서로 소통 할 수 있음 
 *  소켓을 유지하기 위해 쓰레드 객체를 생성함 = 소켓이 accept 상태로 여러개 대기타고 있으면, 
 *  클라이언트가 해당 소켓에 접속해서 통신을 함 / 네트워크 
 * 생성된 스레드 객체를 컬렉션 arraylist에 저장시켜서 사용함  
 * */

// 중간 다리역할
public class MultiServer {
	
		// 어레이리스트 만들어서 다중 쓰레들을 담는 것임 = 배열에 여러개의 쓰레드가 있으므로, 클라가 각 쓰레드 소켓에 접속 시 네트워크 형성되어 통신 가능 
		private ArrayList<MultiServerThread> clientList = new ArrayList<MultiServerThread>();
		
		// 서버 소켓 생성 
		private ServerSocket server = null;
		
		
		public MultiServer () {
			
			try {
				
				// 서버소켓 열면서 포트 번호 설정함 = 클라가 해당 포트로 접속 시 소켓 통신 가능함 
				server = new ServerSocket(5000);
				System.out.println("서버시작");
				
				
				
				// 소켓이 시작되고 나서 계속 기다려야하기때문에 while(true)에   accept();를 써서 소켓을 대기시킴 
				// broadcasting 기능을 이용해서 누군가 서버에 접속하면 뿌려주게 됨 = 안내메세지 같은 경우 
				while (true) {
					
				
				// 소켓안에 read랑 write 메소드를 넣어주는 것임  =>이건 서버쓰레드 객체에 따로 저장함 
					
					Socket socket = server.accept();
					// 클라가 접속하면 접속자의 아이피를 가져와서 그걸 뿌려주게 됨 / 브로드 캐스팅
					// 아이피 얻어오는 것 inetaddress 
					
					
					// 접속한 클라의 아이피 정보를 얻어오는 메소드
					InetAddress ip = socket.getInetAddress();
					
					// 해당 아이피를 String 에다가 저장해서 알림멘트 출력해야함 
					String ipAddress = ip.getHostAddress();
					System.out.println(ipAddress + "님 입장");
					
					
					
					
					// 여기다가 서버쓰레드를 추가하면 됨 
					MultiServerThread t = new MultiServerThread(clientList, socket);
					t.start();
					
					clientList.add(t);
				}
			
				
			} catch (IOException io) {
				System.out.println(io.getMessage());
				
			}
		}
		
		
	
	
	public static void main(String[] args) {

		new MultiServer();
		
		
		
		
		

	}
}
