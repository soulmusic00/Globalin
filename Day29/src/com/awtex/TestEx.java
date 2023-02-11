package com.awtex;
import java.awt.*;
public class TestEx extends Frame {

	private TextField tf = new TextField("제목");
	private TextArea ta = new TextArea("메모", 5, 10);
	private Button bt = new Button("확인");
	private Label la = new Label("내용");
	
	
	public TestEx() {
		super("Test test");
		
		setLayout(new BorderLayout(5,5));
		add("North", tf);
		add("Center", ta);
		add("South", bt);
		add("West", la);
		WinEvent w = new WinEvent();//종료창
//		setLocation(300, 300);
		setSize(300,200);//화면크기 지정
		setVisible(true);//화면 출력여부 
		addWindowListener(w);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		new TestEx();
		
	}

}
