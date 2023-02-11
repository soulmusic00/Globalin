package com.swingex;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class JProgressBarEx extends JFrame implements ActionListener, Runnable {

	
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private JButton jbt = new JButton("시작");
	private JButton jbt1 = new JButton("멈춤");
	
	
	
	
	public JProgressBarEx() {

	
		super("JProgressBar Test");
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		
	
		setSize(new Dimension(300,200));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con.add("North", new JLabel("이것이 프로그래스 바다....")); 
		con.add("Center", jpb);
		jpb.setStringPainted(true);
		jpb.setString("0%");
		
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(jbt);
		jp.add(jbt1);
		
		con.add("South", jp);
		
		
		jbt.addActionListener(this);
		jbt1.addActionListener(this);
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new JProgressBarEx();
	}
	
	
	private boolean bb = true;
	private static int ii;
	
	

	@Override
	public void run() {
		
		if(ii == 100) 
			ii = 0;
			
			
			
			
		 for(int i = ii; i <= 100; i++) {
			if(!bb) break;
			
			try {
				Thread.sleep(50);
			}catch(InterruptedException ee) {}
			
			jpb.setValue(i);
			ii = i;
			jpb.setString(i+"%");
			
		}
		 
		 jbt.setEnabled(true);
		 jbt1.setEnabled(false);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == jbt) {
			bb = true;
			
			new Thread(this).start();
			jbt.setEnabled(false);
			jbt1.setEnabled(true);
			
		}else if(e.getSource() == jbt1) {
			bb = false;
			jbt.setEnabled(true);
			jbt1.setEnabled(false);
		}
		
		
	}


}
