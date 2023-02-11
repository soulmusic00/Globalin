package com.awteventex;

import java.awt.*;
import java.awt.event.*;

public class FocusEventEx extends Frame implements FocusListener {

	private TextField[] tf = new TextField[3];

	private Label lb1 = new Label();
	private Label lb2 = new Label();
	private Label lb3 = new Label();

	public FocusEventEx() {

		super("FocusEvent Test");

		setForm();
		WinEvent w = new WinEvent();// 종료창
		setSize(200, 100);// 사이즈
		setVisible(true);// 화면 출력여부
		addWindowListener(w); // 종료 실행
	}

	public void setForm() {

		setLayout(new BorderLayout());
		Panel p = new Panel(new GridLayout(3, 1));
		p.add(new Label("이름"));
		p.add(new Label("전번"));
		p.add(new Label("주소"));

		add("West", p);

		Panel pp = new Panel(new GridLayout(3, 1));

		for (int i = 0; i < tf.length; i++) {
			tf[i] = new TextField();
			pp.add(tf[i]);
			tf[i].addFocusListener(this);// 리스너 등록
		}

		add("Center", pp);
	}

	public static void main(String[] args) {

		new FocusEventEx();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tf[1]) {
			if (tf[0].getText().trim().length() == 0) {
				tf[0].setText("");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ee) {

				}
				tf[0].requestFocus();
			}

		} else if (e.getSource() == tf[2]) {

			if (tf[1].getText().trim().length() == 0) {
				tf[1].setText("");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ee) {

				}
				tf[1].requestFocus();
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}