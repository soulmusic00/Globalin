package com.book;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;

public class Book extends JFrame implements ActionListener {

	private ImageIcon icon = new ImageIcon("src/img/Roopy2.jpg");
	private int sum = 0;
	// p1
	private JLabel jlb_img;
	private JLabel jlb_income = new JLabel("수입");
	// private JLabel jlb_price;5
	private final String INCOME_LABEL_TEXT = "금액";
	private Choice choice1 = new Choice();
	// private JTextArea jtextArea;
	// private JLabel jlb_memo;
	private JLabel jlb_expense = new JLabel("지출");
	private final String EXPENSE_LABEL_TEXT = "금액";
	private Choice choice2 = new Choice();

	// static을 붙인변수는 클래스명.변수이름
	private JTextField incomePriceText = new JTextField(5);
	private JTextField incomeMemoText = new JTextField(10);
	private JTextField expensePriceText = new JTextField(5);
	private JTextField expenseMemoText = new JTextField(10);

	private Button p1ButtonIncome = new Button("INCOME");
	private Button p1ButtonExpense = new Button("EXPENSE");

	private JTextArea leftDisplay = new JTextArea(30, 10);
	private JTextArea rightDisplay = new JTextArea(30, 10);
	

	private JLabel jlb_balence = new JLabel("현재 잔액: ", JLabel.CENTER);
	private JLabel jlb_sum = new JLabel("0", JLabel.CENTER);

	// 메뉴바
	private JMenuBar JMenuBar = new JMenuBar();

	private JMenu functionJMenu = new JMenu("Function(F)");
	private JMenu calculatorJMenu = new JMenu("Calculator(C)");
	private JMenu helpBarJMenu = new JMenu("Help(H)");

	// 기능
	private JMenuItem saveJMenuItem = new JMenuItem("SaveFile(S)");
	private JMenuItem loadJMenuItem = new JMenuItem("LoadFile(L)");

	// 실행하기
	private JMenuItem execute = new JMenuItem("Execute(E)");

	// 도움말
	private JMenuItem information = new JMenuItem("Information(I)");
     
	// FileDialog(Frame parent, String title, int mode)
		// Creates a file dialog window with the specified title for loading or saving a
		// file
		// The FileDialog class displays a dialog window from which the user can select
		// a file.
		// Since it is a modal dialog, when the application calls its show method to
		// display the dialog, it blocks the rest of the application until the user has
		// chosen a file.
	//파일 다이얼로그 세이브 기능
	private FileDialog fd = new FileDialog(this, "My Save", FileDialog.SAVE);
	
	//파일 다이얼로그 로드 기능 
	private FileDialog loadFd = new FileDialog(this, "My Load", FileDialog.LOAD);
	
	private FileDialog calculateFd = new FileDialog(this, "Calcualte", FileDialog.LOAD);
	
	
	private JPanel Change;
	
	
	Calculate calCulate = new Calculate();
	
	
	
	
	public Book() {

		super("Isaki accoutBook");
		
		

		Container con = this.getContentPane();
		con.setLayout(new GridLayout(1, 2));
		Image img = icon.getImage();

		Image changeImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		jlb_img = new JLabel(changeIcon);

		// Panel p1(GridLayout) - 왼쪽 화면
		Panel p1 = new Panel(new GridLayout(3, 1));

		// Panel p1(GridLayout) - 첫번째 행
		p1.add(jlb_img);

		// Panel P1Input
		Panel p1Input = new Panel(new GridLayout(4, 1));

		// P1 Panel Input(GridLayout(4개 행)
		Panel p1InputIncome = new Panel(new FlowLayout());
		Panel p1InputMemo = new Panel(new FlowLayout());
		Panel p1InputExpense = new Panel(new FlowLayout());
		Panel p1InputMemo2 = new Panel(new FlowLayout());

		// 4개의 행을 p1Input(GridLayout(4,1))에 추가
		p1Input.add(p1InputIncome);
		p1Input.add(p1InputMemo);
		p1Input.add(p1InputExpense);
		p1Input.add(p1InputMemo2);

		// p1 Panel p1InputIncome - (FlowLayout)
		p1InputIncome.add(jlb_income);
		choice1.add("WorkFee");
		choice1.add("MotherFee");
		choice1.add("PartTime");
		p1InputIncome.add(choice1);
		p1InputIncome.add(new JLabel(INCOME_LABEL_TEXT));
		p1InputIncome.add(incomePriceText);

		// p1 memo p1InputIncome - (FlowLayout)
		p1InputMemo.add(new JLabel("메모"));
		p1InputMemo.add(incomeMemoText);

		// p1 expense p1InputIncome - (FlowLayout)
		p1InputExpense.add(jlb_expense);
		choice2.add("Food");
		choice2.add("Transportation");
		choice2.add("Phone");
		p1InputExpense.add(choice2);
		p1InputExpense.add(new JLabel(EXPENSE_LABEL_TEXT));
		p1InputExpense.add(expensePriceText);

		// p1 memo2 - (FlowLayout)
		p1InputMemo2.add(new JLabel("메모"));
		p1InputMemo2.add(expenseMemoText);

		// Panel p1(GridLayout(3,1)) - 두번째 행
		p1.add(p1Input);

		// P1 Panle Button(flowLayout)
		Panel p1Button = new Panel(new FlowLayout());

		// Panel p1Button(FlowLayout)에 p1ButtonIncome, p1ButtonExpense 버튼 추가)
		p1Button.add(p1ButtonIncome);
		p1Button.add(p1ButtonExpense);

		p1ButtonIncome.addActionListener(this);

		p1ButtonExpense.addActionListener(this);
		// Panel p1(GridLayout(3,1)) - 세번째 행
		p1.add(p1Button);

		// 기본 con에 Panel p1 추가
		con.add(p1);

		// Panel p2 (BorderLayout) - 오른쪽 화면
		Panel p2 = new Panel(new BorderLayout());
		
		// Panel p2Sumary (화면과 스크롤을 넣어줄 공간 생성) 
		Panel p2Summary = new Panel(new FlowLayout());
		
		//전체 con에 오른쪽 화면 P2 추가
		con.add(p2);

		JScrollPane jsp1 = new JScrollPane(leftDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane jsp2 = new JScrollPane(rightDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         
		// 오른쪽 화면 Panel p2Summar에 스크롤 바랑 스크롤 패널 추가 
		p2Summary.add(jsp1);
		p2Summary.add(jsp2);

		p2.add("Center", p2Summary);
		
		Panel change = new Panel(new FlowLayout());
		change.add(jlb_balence);
		change.add(jlb_sum);
		p2.add("South", change);

		// JMenu Bar

		setJMenuBar(JMenuBar);
		JMenuBar.add(functionJMenu);
		JMenuBar.add(calculatorJMenu);
		JMenuBar.add(helpBarJMenu);

		functionJMenu.add(saveJMenuItem);
		functionJMenu.add(loadJMenuItem);

		calculatorJMenu.add(execute);

		helpBarJMenu.add(information);

		saveJMenuItem.addActionListener(this);
		loadJMenuItem.addActionListener(this);
		execute.addActionListener(this);
		information.addActionListener(this);
		

//            p2Summary.add(jp);

		setSize(700, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료버튼
		setVisible(true);
		
		leftDisplay.setEditable(false);
		rightDisplay.setEditable(false);
		
//		incomePriceText.setMinimumSize(incomePriceText.getSize());
//		incomePriceText.setMaximumSize(incomePriceText.getSize());
//		incomePriceText.setLineWrap(true);
		
		
//		calCulate.setVisible(true);
//		

	}

	public static void main(String[] args) {

		new Book();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		//p1수입 버튼 눌렀을 경우 이벤트 
		if (e.getSource() == p1ButtonIncome) {

			
			String selectedItem = choice1.getSelectedItem();
			String incomeText = incomePriceText.getText();
			String memoText = incomeMemoText.getText();
			
			int incomeText1 = Integer.parseInt(incomeText);
			sum += incomeText1;
			
			String a = String.valueOf(sum);
			
			jlb_sum.setText(a);
			leftDisplay.append(String.format("%s      %s \n %s \n\n", selectedItem, incomeText, memoText));
			
//			String a = incomePriceText.getText();
//			String b = incomeMemoText.getText();
//			String c =  expensePriceText.getText();
//			String d =  expenseMemoText.getText();

			// JTextArea append 메서드 Appends the given text to the end of the documnet
//			leftDisplay.append("\n\n");
//			leftDisplay.append(a + " ");
//			leftDisplay.append(b + "\n\n");
//
//			int a1 = Integer.parseInt(a);
//
//			sum += a1;
//
//			String a2 = Integer.toString(sum);
//
//			System.out.println(a2);

			// jLabel의 setText메소드 이용 Defines the single line of text this component will
			// display
//			jlb_sum.setText(a2);

		}
		
		// p1 수출 버튼 누룰 때 이벤트
		if (e.getSource() == p1ButtonExpense) {
			String selectedItem1 = choice2.getSelectedItem();
			String expenseText = expensePriceText.getText();
			String memoText1 = expenseMemoText.getText();
			
			int expenseText2 = Integer.parseInt(expenseText);
			sum -= expenseText2;
			
			String b = String.valueOf(sum);
			jlb_sum.setText(b);
			
			rightDisplay.append(String.format("%s      %s \n %s \n\n", selectedItem1, expenseText, memoText1));
			
			
//			String c = expensePriceText.getText();
//			String d = expenseMemoText.getText();
//
//			rightDisplay.append("\n\n");
//			rightDisplay.append(c + " ");
//			rightDisplay.append(d + "\n\n");
//
//			int c1 = Integer.parseInt(c);
//
//			sum -= c1;
//
//			String c2 = Integer.toString(sum);
//
//			jlb_sum.setText(c2);
//
//		}
//
//		if (e.getSource() == saveJMenuItem) {
//			fd.setVisible(true);
//
//			String path = fd.getDirectory();
//			String name = fd.getFile();
//
//			FileWriter writer = null;
//
//			String a = leftDisplay.getText();
//			String b = rightDisplay.getText();
//
//			try {
//				writer = new FileWriter(path + name);
//
//				System.out.println(writer);
//
//				writer.write(a);
//				writer.write(b);
//				writer.flush();
//
//			} catch (FileNotFoundException fn) {
//				// TODO Auto-generated catch block
//				fn.printStackTrace();
//			} catch (IOException ii) {
//				ii.printStackTrace();
//
//			} finally {
//
//				try {
//					if (writer != null)
//						writer.close();
//				} catch (IOException eee) {
//
//				}
//			}
//			
//			
			
			
		}
		
		
		//저장하기
//		System.out.println("디버깅");
		if (e.getSource() == saveJMenuItem) {
			fd.setVisible(true);

			String path = fd.getDirectory();
			String name = fd.getFile();
			System.out.println(path);
			System.out.println(name);

			// 정규 표현식 이용방법
			// 왼쪽 화면에 텍스트 내용을 가져옴
			String a = leftDisplay.getText();
			
			// 오른쪽 화면에 텍스트 내용을 가져옴 
			String b = rightDisplay.getText();

			System.out.println(a);
			System.out.println(b);

			// 파일 저장
			FileWriter writer = null;

			try {

				writer = new FileWriter(path + name);
				
				System.out.println(writer);
				
				
				
				writer.write(a + "\n---\n" + b);
				writer.flush();

			} catch (FileNotFoundException fn) {
				fn.printStackTrace();
			} catch (IOException ii) {
				ii.printStackTrace();

			} finally {

				try {
					if (writer != null)
						writer.close();
				} catch (IOException eee) {

				}
			}

			// 불러 오기 소스
		}

		if (e.getSource() == loadJMenuItem) {
			loadFd.setVisible(true);

			String path = loadFd.getDirectory();
			String name = loadFd.getFile();
			System.out.println(path);
			System.out.println(name);

			// 파일 읽어오기
			BufferedReader reader = null;
			//파일 내용을 한 줄 씩 읽이 위해서

			try {
				// char reader.read();
				reader = new BufferedReader(new FileReader(path + name));
				String readValue = null;

				String result = "";
				while ((readValue = reader.readLine()) != null) {
					result += (readValue + "\n");
				}

				System.out.print(result);

				String a[] = result.split("\n---\n");

				leftDisplay.setText(result);
				
//				
				leftDisplay.setText(a[0]);
				rightDisplay.setText(a[1]);

			} catch (FileNotFoundException fe) {
				fe.printStackTrace();
			} catch (IOException ie) {
				ie.printStackTrace();
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException ie) {
				}

			}

		}

		System.out.println(sum);
		
		if(e.getSource() == execute) {
			calCulate.setVisible(true);
			
		}
		
		if(e.getSource() == information) {
		String message = "Isaki & Junha Account Book for all people. \n version: Isaki & Junha Account Book Service Release 1.1\n(c):Copyright Isaki and Junha, 2023.01. \n All rights reserved.";
		
		JOptionPane.showMessageDialog(null, message , "Account Book Information", JOptionPane.INFORMATION_MESSAGE);
		
		
		}
		
		
		
		
	}

}