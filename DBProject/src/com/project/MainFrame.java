package com.project;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

	
	private JTabbedPane tp;
	private AddPane ap;
	private FindPane fp;
	private TotalPane ttp;
	
	
	public MainFrame() {
		
		tp = new JTabbedPane();
		ap = new AddPane();
		fp = new FindPane();
		ttp = new TotalPane();
		
		
		tp.addTab("사원정보입력" , ap);
		tp.addTab("사원정보조회", fp);
		tp.addTab("전체사원보기", ttp);
		
		getContentPane().add(tp);
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료버튼
		setVisible(true);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		new MainFrame().setSize(600, 600);
		
		
		
		
		
		

	}

}
