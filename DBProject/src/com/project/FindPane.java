package com.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FindPane extends JPanel implements ActionListener {

	private JPanel jp[] = new JPanel[6];
	private JLabel jl[] = new JLabel[5];
	private JTextField tf[] = new JTextField[5];

	private JButton okb;// 저장버튼
	private JButton rsb;// 다시 쓰기

	EmployeeDAO edvo;
	
	private int department = 10;

	String[] caption = { "번호", "이름:", "직책:", "메일:", "부서:" };

	public FindPane() {
		setLayout(new GridLayout(7, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);

		int size = caption.length;

		int i;
		for (i = 0; i < size; i++) {
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);

			jp[i].add(jl[i]);
			jp[i].add(tf[i]);

			add(jp[i]);

			tf[i].setEditable(false);

			if (i == 0 || i == 1) {
				tf[i].setEditable(true);
			}

		}

		jp[size] = new JPanel();
		okb = new JButton("사원정보 조회");
		okb.addActionListener(this);

		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);

		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[i]);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String ae_type = ae.getActionCommand();
		EmployeeVo evo = null;// db에 저장
		EmployeeDAO evdo = null;

		if (ae_type.equals(okb.getText())) {
			
			try {
				
				edvo = new EmployeeDAO();
				String sno = tf[0].getText().trim();
				String sname = tf[1].getText().trim();
				
				if(!sno.equals("") & !sname.equals("")) {
					int no = Integer.parseInt(sno);
					evo = edvo.getEmployeeCheck(no, sname);
				}else if(!sno.equals("") & sname.equals("")) {
					int no = Integer.parseInt(sno);
					evo = edvo.getEmployeeNo(no);
				}else if(sno.equals("") & !sname.equals("")) {
					evo = edvo.getEmployeeName(sname);
				
				}
				
				
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
			} 
			
			if(evo != null) {
				tf[0].setText(evo.getNo() + "");
				tf[1].setText(evo.getName() + "");
				tf[2].setText(evo.getJobGrade() + "");
				tf[3].setText(evo.getDepartment() + "");
				tf[4].setText(evo.getEmail() + "");
				
			}else {
				JOptionPane.showMessageDialog(this, "검색 실패");
			}
			

		} else if (ae_type.equals(rsb.getText())) {
			
			int size = caption.length;
			for (int i = 0; i < size; i++)
				tf[i].setText("");// 초기화

		}

	}

}
