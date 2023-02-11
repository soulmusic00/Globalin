package com.book;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.StringTokenizer;

public class Calculate extends JFrame {
   
   private boolean reset = true;
   private JTextField inputSpace;
   private String [] str = {"","","←","CE","C","7","8","9","/","sqrt","4","5","6","*","%","3","2","1","-","1/x","0","+/-",".","+","="};
   private Button [] bt = new Button [str.length]; 
   private JPanel jPanel = new JPanel(new GridLayout(6,6,5,5));
   
   public Calculate() {
   super("Calculate Text");
   inputSpace = new JTextField("0");
   inputSpace.setEditable(false);
   inputSpace.setHorizontalAlignment(JTextField.LEFT);
   //Layout설정 
   getContentPane().setLayout(new BorderLayout()); //가로 ,세로, 가로갭,세로갭
   getContentPane().add("North", inputSpace);
   getContentPane().add("Center", jPanel);
   
   for (int i=0;i<bt.length;i++) {
      bt[i]=new Button(str[i]);
      bt[i].setFont(new Font("바탕체굴림체",Font.BOLD,10));
      jPanel.add(bt[i]);
      bt[i].addActionListener(new BtnClickListener());
   }
   
   setSize(300,370);//화면크기 지정
//   setVisible(true);//화면 출력여부 
   setLocationRelativeTo(null);//사이즈 조절 불가능 
//   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을닫을때 실행중인 프로그램도 같이 종료되도록함
   }
   
   
   
   class BtnClickListener implements ActionListener {
	public String Result(String str) {
		String token;
		StringTokenizer ST = new StringTokenizer(str, "+-*/", true);
		token = ST.nextToken();
		double amount = Double.parseDouble(token);
		while(ST.hasMoreTokens()) {
			token = ST.nextToken();
			if(token.equals("+")) {
				token = ST.nextToken();
				amount += Double.parseDouble(token);
			}
			else if(token.equals("-")) {
				token = ST.nextToken();
				amount -= Double.parseDouble(token);
			}
			else if(token.equals("*")) {
				token = ST.nextToken();
				amount *= Double.parseDouble(token);
			}
			else if(token.equals("/")) {
				token = ST.nextToken();
				amount /= Double.parseDouble(token);
			}
		}
		
		return "" + amount;
	}
	   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String content = e.getActionCommand();
				
		if(content.equals("")) {
			
		} else if(content.equals("sqrt")) {
			
		} else if(content.equals("1/x")) {
			
		} else if(content.equals("+/-")) {
			
		} else if(content.equals("%")) {
			
		} else if(content.equals("←")) {
			inputSpace.setText(inputSpace.getText().substring(0, inputSpace.getText().length()-1));
			reset = false;
		}
		else if(content.equals("CE")) {
			inputSpace.setText("0");
			reset = true;
		}
		else if(content.equals("C")) {
			inputSpace.setText("0");
			reset = true;
		}
		else if(content.equals("+")) {
			inputSpace.setText(inputSpace.getText() + "+");
			reset = false;
		}
		else if(content.equals("-")) {
			inputSpace.setText(inputSpace.getText() + "-");
			reset = false;
		}
		else if(content.equals("*")) {
			inputSpace.setText(inputSpace.getText() + "*");
			reset = false;
		}
		else if(content.equals("/")) {
			inputSpace.setText(inputSpace.getText() + "/");
			reset = false;
		}
		else if(content.equals("=")) {
			inputSpace.setText(Result(inputSpace.getText()));
			reset = true;
		}
		else {
			if(reset == true) {
				inputSpace.setText(content);
				reset = false;
			}
			else {
				inputSpace.setText(inputSpace.getText() + content);
			}
		}
		
		
	}
	   
   }
   
   public static void main(String[] args) {
   
      new Calculate();
      
      
   }

}
