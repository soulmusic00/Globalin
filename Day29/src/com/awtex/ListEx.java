package com.awtex;
import java.awt.*;
public class ListEx extends Frame{
	
	private Label la = new Label("과목이름");
	private List li =new List(4,true);
	
	private Button bt =new Button("확인");
	private String[] name;
//	private String [] a = {"Java","Jsp","Database","Spring"};
	
	public ListEx(String[] a) {
		
	super ("List Test");
	
	this.name = a;
	
	setLayout(new BorderLayout());
	for(int i=0;i<name.length;i++) {
		li.add(name[i]);
	}
	
	li.setFont(new Font("궁서체", Font.BOLD, 30));
	
	add("North", la);
	add("Center", li);
	add("South", bt);
	
	WinEvent w = new WinEvent();//종료창
	setSize(300,200);//화면크기 지정
	setVisible(true);//화면 출력여부 
	addWindowListener(w);
		
	}

	public static void main(String[] args) {
		
		String [] a = {"Java","Jsp","Database","Spring"};
		
		new ListEx(a);

	}

}