package com.swingex;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
public class ImageEx {

	public static void main(String[] args) {

		JFrame f = new JFrame("이미지 로딩 ");
		f.setLocation(500, 200);  //위치
		f.setPreferredSize(new Dimension(400,350)); //크기
		Container con = f.getContentPane();
		
		ImagePanel imagePanel = new ImagePanel();
		con.add(imagePanel, BorderLayout.CENTER);
		
		
		
		JPanel controlPanel = new JPanel();
		JTextField text = new JTextField(30);
		JButton button = new JButton("이미지 로드");
		
		controlPanel.add(text);
		controlPanel.add(button);
		
		con.add(controlPanel, BorderLayout.SOUTH);
		
		
		
		
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
