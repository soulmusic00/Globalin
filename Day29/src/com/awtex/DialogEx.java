package com.awtex;
import java.awt.*;
public class DialogEx extends Frame {
//컴포넌트 정의
	private Dialog d = new Dialog(this,"조회 서비스",false);
	
	private Label dla1 = new Label("이름과 주민번호로 비밀번호 찾기");
	private Label dla2 = new Label("이름",Label.RIGHT);
	private Label dla3 = new Label("주민번호",Label.RIGHT);
	private Label dla4 = new Label("-",Label.CENTER);
	
	private TextField dtf1 = new TextField(20);
	private TextField dtf2 = new TextField(6);//주민앞자리
	private TextField dtf3 = new TextField(7);//주민 뒷자리
	
	private Button dbt1 = new Button("search");
	private Button dbt2 = new Button("cancle");
	
	
	
	public DialogEx() {
		
		super("Dialog Test");
		
		setDialog();
		WinEvent w = new WinEvent();//종료창
		setSize(300,200);//사이즈
		setVisible(true);//화면 출력여부 
		addWindowListener(w); //종료 실행 
		d.setVisible(true);
	}
	
	private void setDialog() {//사용자정의 메소드 ,위에 건들일필요 x
	
		d.setLayout(new BorderLayout());
		d.add("North",dla1);
		
		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new GridLayout(2,1));
		
		
		
		p2.add(dla2);
		p2.add(dla3);
		p1.add("West",p2);//p1에 p2를 왼쪽에 넣어줌
		
		Panel p3 = new Panel(new GridLayout(2,1));
		Panel tfPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		tfPanel.add(dtf1);
		p3.add(tfPanel);
		
		
		p4.add(dtf2);
		p4.add(dla4);
		p4.add(dtf3);
		
		p3.add(tfPanel); //p3에 tfpanel추가해줌
		p3.add(p4);
		
		p1.add("Center",p3);
		
		Panel p = new Panel(new FlowLayout());
		p.add(dbt1);
		p.add(dbt2);
		
		d.add("Center",p1);//dialog 에 p1을 center에 넣어줌 
		d.add("South",p);
		
		d.setSize(260,150);
		d.setResizable(false);
		
	}
	
	public static void main(String[] args) {
		

		new DialogEx();
	}

}