package com.awtex;

import java.awt.*;

public class CheckboxGroupEx extends Frame {

	private GridLayout gl = new GridLayout(4,1);
	private Label la = new Label("gender");
	private CheckboxGroup cg = new CheckboxGroup();
	private Checkbox man = new Checkbox("M",cg, true);
	private Checkbox woman = new Checkbox("F",cg, false);
	private Button bt = new Button("Confirm");
	
	
	public CheckboxGroupEx() {
		
		setLayout(gl);
		
		add(la);
		add(man);
		add(woman);
		add(bt);
		
		
		
		
		
		WinEvent w = new WinEvent();
		pack();
		setVisible(true);
		addWindowListener(w);

	}

	public static void main(String[] args) {

		new CheckboxGroupEx();
		
		
		
	}

}
