package com.awtex;
import java.awt.*;
public class ButtonEx extends Frame {

	private String [] str = {"7","8","9","4","5","6","1","2","3","#","0","*"};
	private Button [] bt = new Button [str.length]; 
	
	
	public ButtonEx() {
	//Frame 부모에서 접근제어자 Protected public은 자식이 사용할 수 있다.
	//Frame(부모)의 생성자 호출
	// 부모의 기능을 쓰기 위해서 부모의 생성자 호출자
	super("Button Text"); //?
	//Layout설정 
	setLayout(new GridLayout(4,3,5,5)); //가로 ,세로, 가로갭,세로갭
	
	for (int i=0;i<bt.length;i++) {
		bt[i]=new Button(str[i]);
		bt[i].setFont(new Font("궁서체",Font.BOLD,30));
		add(bt[i]); //?
	}
	
	
		
	WinEvent w = new WinEvent();//종료창
	setSize(300,200);//화면크기 지정
	setVisible(true);//화면 출력여부 
	addWindowListener(w); //?
	}
	public static void main(String[] args) {
	
		new ButtonEx();
		
	}

}