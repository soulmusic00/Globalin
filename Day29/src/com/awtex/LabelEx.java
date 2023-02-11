package com.awtex;

import java.awt.*;

public class LabelEx extends Frame {

	Label la1;
	Label la2;
	Label la3;
	Label la4;
	Font f1;
	Font f2;

	public LabelEx() {

		super("Label Test");

		f1 = new Font("굴림체", Font.BOLD, 20);
		f2 = new Font("궁서체", Font.ITALIC, 25);

		la1 = new Label("안녕하세요");
		la2 = new Label("홍길동입니다.", Label.CENTER);
		la3 = new Label("활빈당입니다.", Label.RIGHT);
		la4 = new Label("반갑습니다..");

		setLayout(new GridLayout(4, 1));

		setSize(300, 200);
		setVisible(true);
		WinEvent w = new WinEvent();
		addWindowListener(w);

		la1.setFont(f1);
		la2.setFont(f1);
		la3.setFont(f2);
		la4.setFont(f2);

		add(la1);
		add(la2);
		add(la3);
		add(la4);

		la1.setBackground(Color.red);
		la2.setBackground(Color.blue);
		la3.setBackground(Color.green);
		la4.setBackground(Color.pink);

	}

	public static void main(String[] args) {

		new LabelEx();

	}
}
