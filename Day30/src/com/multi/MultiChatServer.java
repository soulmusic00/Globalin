package com.multi;



import java.net.*;
import java.io.*;
import java.util.*;

import javax.management.relation.RoleUnresolvedList;
import com.multiex.MultiServer;


public class MultiChatServer {

	
	// 서버소켓과 클라이언트 연결 소켓 
	private ServerSocket ss = null;
	private Socket s = null;
	
	
	// 클라가 접속 할 수 있게 쓰레드를 만들기 위해서 리스트 만듦 
	private ArrayList<ChatThread> chatlist = new ArrayList<ChatThread>();
	// 누가 챗방에서 나가면 상기 리스트에서 지우고, 사람들에게 ~~가 나갔습니다. 멘트 날림 
	
	
	// 채팅 프로그램을 실행하는 메인 
	//시작 메소드
	public void start() {
		
		try {
			
			// 서버소켓 생성  // 각 프로그램을 돌아가게 하는 통로 ==> port
			ss = new ServerSocket(6000);
			// 클라는 서버의 ip와 포트번호를 알아야만 네트워크 접속 가능함 
			System.out.println("서버 시작");
			
			
			// 서버가 대기타야하므로 무한루프 while 써야함 그리고 accept ();
			while(true) {
				
				// 전역에서 만든 클라와 통신위한 소켓에 서버소켓 대기타기(accept)를 걸어줌
				s =  ss.accept();
				
				// 연결 된 클라에게 스레드 생성해줌 
				ChatThread chat = new ChatThread();
				
				// 챗리스트에 상기 챗쓰레드를 집어넣음 
				chatlist.add(chat);
				// chatlist는 클라이언트 각각을 집어넣는 집합체임 / 해당 집합체에 개별 챗쓰레드를 각각 넣어주게 되는 것임
				
				// 쓰레드 스타트! 한 후에 입출력 스트림을 만들어줘야 함 
				chat.start();

			}
			
			
		} catch (Exception e) {
			System.out.println("[MultiChatServer]start() Exception이 발생");
		}
		
	}
	
	
	// 모든 사용자에게 알리는 메소드
	public void msgSendAll(String msg) {

		// ct로 클라이언트 리스트를 치환시킨 다음에 스트림을 만들어서 해당 스트림으로 클라이언트 모두에게 보냄 
		for(ChatThread ct : chatlist) {
			ct.outMsg.println(msg);
	
		}
		

		
	}
	
	// 클라이언트 관리를 위한 스레드 클래스
	class ChatThread extends Thread  {
		

			// 수신 메시지와 파싱 메시지를 처리할 변수를 선언
			String msg;
			String[] rmsg;
			
			//입출력 스트림을 생성
			private BufferedReader inMsg = null;
			private PrintWriter outMsg = null;
		

		
		@Override
		public void run() {
			
			boolean status = true;
			System.out.println("##ChatThread gets started! ");
			
			try {
				
				//입출력 스트림 
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg = new PrintWriter(s.getOutputStream(),true);
				
				
				// 루프를 돌면서 클라로부터 수신된 메시지를 처리함 
				while(status) {
					//수신된 메시지를 msg변수에 저장 
					msg = inMsg.readLine();
					// '/' 구분자를 기준으로 메시지를 문자열 배열로 파싱
					rmsg = msg.split("/");
				
				
				
				// 파싱된 문자열 배열의 두 번째 요소값에 따라 처리
				// 로그아웃 메시지일 때
				if(rmsg[1].equals("logout")) {
				chatlist.remove(this);
				msgSendAll("server/" + rmsg[0] + "님이 종료했습니다.");
				// 해당 클라이언트 스레드 종료로 status를 false로 설정
				status = false;
				}
				// 로그인 메시지일 때
				else if(rmsg[1].equals("login")) {
				msgSendAll("server/" + rmsg[0] + "님이 로그인했습니다.");
				}
				// 그 밖의 일반 메시지일 때
				else {
				msgSendAll(msg);
				}
			} // while 종료
	
			
			// 루프를 벗어나면 클라이언트 연결이 종료되면서 스레드에 인터럽트가 발생됨
			this.interrupt();
			System.out.println("##"+this.getName()+"stop!!!");
				
			} catch (IOException e) {
				chatlist.remove(this);
				System.out.println("[ChatThread]run()IOException 발생함");
			}
	}
}
	
	
	
	
	public static void main(String[] args) {
		// 이렇게 써도 됨
		//MultiChatServer ms = new MultiChatServer();
		// ms.start();

		new MultiChatServer().start();

	}

}
