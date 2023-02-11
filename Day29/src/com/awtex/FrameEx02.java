
package com.awtex;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEx02 extends Frame implements WindowListener {

	public FrameEx02() {
		super("이번트1");
		setSize(300, 200);
		setVisible(true);
//		WinEvent ww = new WinEvent();
		addWindowListener(this);
	}

//	class WinEventEx01 extends WindowAdapter {
//
//		public WinEventEx01() {
//			System.exit(0);
//
//		}
//
//	}

	public static void main(String[] args) {
		new FrameEx02();
		// 프레임 객체 생성
		/*
		 * Frame f =new Frame (); WinEvent w = new WinEvent(); setSize(300, 200);
		 * setVisible(true); addWindowListener(this);
		 */
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}