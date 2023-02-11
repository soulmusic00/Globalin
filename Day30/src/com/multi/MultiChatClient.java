package com.multi;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.nio.channels.ClosedByInterruptException;

import javax.swing.*;
import javax.swing.event.*;

public class MultiChatClient  implements ActionListener, Runnable {
	
	private String ip; // 서버 ip
	private String id; // 로그인 / 로그아웃

	private Socket socket;
	
	// 입출력 스트림 
	private BufferedReader inMsg = null;
	private PrintWriter outMsg = null;
	
	// 로그인 패널 
	private JPanel loginPanel; 
	private JButton loginButton;
	private JLabel label1;
	private JTextField idInput;
	
	//로그아웃 패널 
	private JPanel logoutPanel;
	private JLabel label2;
	
	private JButton logoutButton;
	
	//메세지 입력 패널
	private JPanel msgPanel;
	private JTextField msgInput;
	
	//종료버튼 
	private JButton exitButton;
	
	
	// 채팅창 . 이렇게 해도 되고, 아니면 그냥 클래스 자체에 상속해도 됨 
	private JFrame jframe;
	
	
	//채팅 내용 출력창 
	private JTextArea msgOut;
	
	
	// 카드 레이아웃
	
	private Container tab;
	private CardLayout clayout;
	private Thread thread;
	
	boolean status;

	
	public MultiChatClient (String ip) {
		this.ip = ip;
		
		loginPanel = new JPanel();
		
		loginPanel.setLayout(new BorderLayout());
		idInput = new JTextField(15);
		loginButton = new JButton("로그인");
		loginButton.addActionListener(this);
		
		label1 = new JLabel("대화명");
		
		loginPanel.add(label1,BorderLayout.WEST);
		loginPanel.add(idInput,BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		label2 = new JLabel();
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(this);
		
		logoutPanel.add(label2, BorderLayout.CENTER);
		logoutPanel.add(logoutButton, BorderLayout.EAST);

		msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		msgInput = new JTextField(30);
		msgInput.addActionListener(this);
		
		
		exitButton = new JButton("종료");
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		exitButton.addActionListener(this);
		
		
		
		
		// 로그인/ 로그아웃 패널을 선택하기 위한 카드레이아웃 패널 구성 
		tab = new JPanel();
		clayout = new CardLayout();
		tab.setLayout(clayout);
		tab.add(loginPanel,"login");
		tab.add(logoutPanel,"logout");
		
		
		
		
		
		
		// 메인 프레임 구성
		jframe = new JFrame("::멀리챗::");
		msgOut = new JTextArea("",10,30);
		msgOut.setEditable(false); //  수정불가 
		
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		jframe.add(tab,BorderLayout.NORTH);
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(msgPanel,BorderLayout.SOUTH);
		
		
		// 로그인패너를 먼저 표시 
		clayout.show(tab, "login");
		jframe.pack();
		jframe.setResizable(false);// 프레임크기 수정 불가 
		jframe.setVisible(true);
		
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
		
	}
	
	
	
	
	public void connectServer() {
		
		try {
			//소켓생성
			//서버를 띄운 컴퓨터의 아이피와 서버의 포트
			socket = new Socket("192.168.0.51",6000);
			System.out.println("[Client]Server 연결 성공");
			
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(),true);
			
			// 서버에 메세지 전달 
			outMsg.println(id+"/"+"login");
			
			thread = new Thread(this);
			thread.start();

		} catch (Exception e) {
			System.out.println("[MultiChatClient]connectSever() Exception이 발생");
		}
		}
		
		
		
	@Override
	public void run() {
		// 수신된 메세지를 처리하는 변수 
		
		String msg;
		String[] rmsg;
		
		status = true;
		
		while(status) {
			
			try {
				
				// 메세지 수신과 파싱 
				msg = inMsg.readLine();
				rmsg = msg.split("/");
				
				//JTextArea 에 수신된 메시지를 추가함 
				msgOut.append(rmsg[0]+">"+rmsg[1]+"\n");
				
				// 커서를 현재 대화 메시지에 표시함 
				msgOut.setCaretPosition(msgOut.getDocument().getLength());

				
			} catch (IOException ii) {
				status = false;
				
			}
		}
				System.out.println("[MultiChatClient]"+thread.getName()+"가 종료 되었습니다.");

	}

	
	// 이벤트 처리는 버튼에 추가시킴 
		// 액션퍼폼ㄷ 액션 이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		// 종료버튼= 버튼 누르면 액션 발생
		if(obj == exitButton) {
			
				System.exit(0);
			

			//로그인 버튼
		}else if(obj == loginButton) {
			
			//아이디를 가져옴 
			id = idInput.getText();
			//가져온 아이디를 대화명에 실어서 setText로 보냄 
			label2.setText("대화면"+id);
			clayout.show(tab, "logout");
			
			// 로그인 되면 서버랑 연결함 // 위에 만들어 놓은 컨낵트 서버 메소드 불러옴
			connectServer();

			
			//로그아웃 버튼
		}else if(obj == logoutButton) {
			
				//로그아웃 메시지 출력 
				outMsg.println(id+"/"+"logout");
				//텍스트 빈칸으로 초기화 
				msgOut.setText("");
				// 버튼 로그인으로 바꿈
				clayout.show(tab, "login");
				outMsg.close();
				try {
					inMsg.close();
					socket.close();
				} catch(IOException ee) {
					ee.printStackTrace();
				}
				
				status= false;
			
			//메세지 입력
		}else if(obj == msgInput) {
			
			// 메시지를 전송하고 
			outMsg.println(id+"/"+msgInput.getText());
			// 메시지 입력창을 빈 칸으로 초기화 시킴
			msgOut.setText("");
			
			
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			new MultiChatClient("127.0.0.1");
		
	}
}
