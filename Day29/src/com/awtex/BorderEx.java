package com.awtex;

import java.awt.*;

public class BorderEx extends Frame {

	Label a, b, c, d, e;

	public BorderEx() {

		
		super("BorderLayout");
		
		// new class() ==> 생성자 호출이므로
		// new BorderLayout(5,5)) ==> 생성자 호출
		setLayout(new BorderLayout(5,5)); //?
		
		
		a = new Label("↑", Label.CENTER);
		b = new Label("↓", Label.CENTER);
		c = new Label("←", Label.CENTER);
		d = new Label("→", Label.CENTER);
		e = new Label("이동", Label.CENTER);
	
		setBackground(Color.gray);
		
		
		add("North", a);
		//add(a, BorderLayout.NORTH);
		add("South", b);
		//BorderLayout.WEST WEST는 static으로 만든 전역변수(Class 변수)
		
		add(c, BorderLayout.WEST);  //?
		add(d, BorderLayout.EAST);  //?
		add("Center", e);
		
		WinEvent w = new WinEvent();
         
		
//		setBounds(300, 300, 300, 200);
		setLocation(300,300); //?
		setSize(300, 200);
		setVisible(true);
		
		a.setBackground(Color.red);
		b.setBackground(Color.green);
		c.setBackground(Color.blue);
		d.setBackground(Color.magenta);
		e.setBackground(Color.CYAN);
		
		a.setForeground(Color.white); //?
		b.setForeground(Color.white);
		c.setForeground(Color.white);
		d.setForeground(Color.white);
		
		
		//		pack();
		addWindowListener(w);
		
		
		
		

	}

	public static void main(String[] args) {

		new BorderEx();

	}

}
