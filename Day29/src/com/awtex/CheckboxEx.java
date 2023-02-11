package com.awtex;

import java.awt.*;

public class CheckboxEx extends Frame {

	private Label lb = new Label("fruit");
	private Checkbox[] cb = { new Checkbox("Banana", true), new Checkbox("strawberry"), new Checkbox("strawberry"),
			new Checkbox("pineapple") };
	private Button bt = new Button("Confirm");

	public CheckboxEx() {

		super("CheckBox TEst");
		setLayout(new GridLayout(5, 1));

		add(lb);

		for (int i = 0; i < cb.length; i++) {

			add(cb[i]);

		}

		add(bt);

		WinEvent w = new WinEvent();
		pack();
		setVisible(true);
		addWindowListener(w);

	}

	public static void main(String[] args) {

		new CheckboxEx();

	}

}
