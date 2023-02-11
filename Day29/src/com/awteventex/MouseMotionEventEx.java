package com.awteventex;

import java.awt.*;
import java.awt.event.*;

public class MouseMotionEventEx extends Frame implements MouseMotionListener {

	public MouseMotionEventEx() {
		WinEvent w = new WinEvent();

		setSize(300, 200);
		setVisible(true);
		addWindowListener(w);
		addMouseMotionListener(this);

	}

	WinEvent w = new WinEvent();

	@Override
	public void mouseDragged(MouseEvent e) {

		if (e.getSource() == this) {
			System.out.println("x:" + e.getX() + "y:" + e.getY());
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() == this) {
			System.out.println("x:" + e.getX() + "y:" + e.getY());
		}
	}

	public static void main(String[] args) {

		new MouseMotionEventEx();

	}
}
