package com.awteventex;

import java.awt.*;
import java.awt.event.*;

public class KeyEventEx extends Frame implements KeyListener {

	private Label la = new Label("주민번호: ", Label.RIGHT);
	private Label la1 = new Label(" - ", Label.CENTER);

	private TextField jumin1 = new TextField(10);
	private TextField jumin2 = new TextField(10);

	private Button bt = new Button("confirm");

	public KeyEventEx() {

		WinEvent w = new WinEvent();// 종료창

		setSize(300, 200);
		setVisible(true);
		addWindowListener(w);
		setForm();

		pack();
		jumin1.addKeyListener(this);
		jumin2.addKeyListener(this);

	}

	public static void main(String[] args) {
		new KeyEventEx();
	}

	private void setForm() {

		setLayout(new BorderLayout());
		add("West", la);

		Panel p = new Panel(new FlowLayout(FlowLayout.LEFT));
		p.add("west", jumin1);
		p.add("Center", la1);
		p.add("East", jumin2);
		add("Center", p);

		Panel p1 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(bt);
		add("South", p1);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getSource() == jumin1) {
			if (jumin1.getText().trim().length() == 6) {
				jumin2.requestFocus();

			}

			if (e.getSource() == jumin2) {
				if (jumin2.getText().trim().length() == 7) {
					bt.requestFocus();
				}
			}

		}
	}
}
