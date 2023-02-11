package com.awtex;

import java.awt.*;
public class FrameEx04 extends Frame {
	
	
	public FrameEx04() {
		super("test2");
		setSize(300, 200);
		setVisible(true);
		WinEvent w = new WinEvent();
		addWindowListener(w);
	}
	
	public static void main(String[] args) {
		new FrameEx02();
	}
	
	
	
	
}
