
package com.awtex;

import java.awt.*;
import java.awt.event.*;

public class FrameEx03 extends Frame {

	public FrameEx03() {
		super("이번트1");
		setSize(300, 200);
		setVisible(true);
		//1회성으로 사용하기 위해서
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}



	public static void main(String[] args) {
		new FrameEx03();
		// 프레임 객체 생성
		/*
		 * Frame f =new Frame (); WinEvent w = new WinEvent(); setSize(300, 200);
		 * setVisible(true); addWindowListener(this);
		 */
	}

//	@Override
//	public void windowOpened(WindowEvent e) {
//
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//
//		System.exit(0);
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//
//	}

}