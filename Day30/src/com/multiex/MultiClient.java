package com.multiex;



import java.net.*;
import java.io.*;



public class MultiClient {
	
			// 메시지 주고받기 위해서 리더랑 라이터 일단 호출해놓음 
			private Socket socket = null;
			private BufferedReader in = null;
			private PrintWriter out = null;
			private BufferedReader keyboard = null;
	
	
		public MultiClient () {
			
			try {
				
				// 클라에 소켓 만들고, 서버 연결 시킴 
				// 로컬호스트에, 포트 5000번 넣고 접속 
				// 접속 멘트 출력
				
				//192.168.0.113
				socket = new Socket("192.168.0.11",5000);
				System.out.println("서버연결 됨");
				
				
				keyboard = new BufferedReader(new InputStreamReader(System.in)); //키보드 입력 
				out = new PrintWriter(socket.getOutputStream(),true); 
				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
				
				
				/*
				 *  서버가 전송한 메세지를 수신할 쓰레드 생성 
				 *  
				 *  MultiClientThread 생성 시에 서버가 전송한 메세지를 읽어들일 수 있는 스트림을 전달함..? 스트림은 통론데 뭔 스트림을 전달?

				 * */
				
				MultiClientThread t = new MultiClientThread(in);  ///다른 사람이 입력한것을 받는것
				t.start();
				
				
				// 계속 통신 해야되니까 while 
				while(true) {
					String text = keyboard.readLine();             // 내가 써서 보내는거 
					out.println(text);
				}
				
				
			} catch (UnknownHostException ue) {
				System.out.println("서버 연결 실패");
				
			}catch (IOException io) {
					io.printStackTrace();
			}
			
			
			
			
			
		}
	

	public static void main(String[] args) {
		new MultiClient();

	}

}
