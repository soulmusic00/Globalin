package com.awtex;

import java.awt.*;

public class MenuEx extends Frame {

	private MenuBar mb = new MenuBar();
    
	private Menu file = new Menu("file");
	private Menu edit = new Menu("ToolKit");
	private Menu view = new Menu("View");
	private Menu help = new Menu("Help");
	private Menu ecolor = new Menu("Color");
	private Menu esize = new Menu("Size");

	private MenuItem fnew = new MenuItem("NewFile");
	private MenuItem fopen = new MenuItem("FileOpen");
	private MenuItem fsave = new MenuItem("FileSave");
	private MenuItem fsaves = new MenuItem("FileSaveAs");
	private MenuItem fexit = new MenuItem("Exit");

	private CheckboxMenuItem ecred = new CheckboxMenuItem("Red");
	private CheckboxMenuItem ecgreen = new CheckboxMenuItem("Green");
	private CheckboxMenuItem ecblue = new CheckboxMenuItem("Blue");

	private CheckboxMenuItem es10 = new CheckboxMenuItem("10");
	private CheckboxMenuItem es20 = new CheckboxMenuItem("20");
	private CheckboxMenuItem es30 = new CheckboxMenuItem("30");
	
	private Button bt1 = new Button("Confirm");
	private Button bt2 = new Button("Cancel");
	
	
	
	public MenuEx() {

		super("Menu Test");
		
		setMenuBar(mb);
		mb.add(file);
		mb.add(edit);
		mb.add(view);
		mb.add(help);
		mb.add(ecolor);
		mb.add(esize);
		
		ecolor.add(ecred);
		ecolor.add(ecgreen);
		ecolor.add(ecblue);
		
		esize.add(es10);
		esize.add(es20);
		esize.add(es30);
		
		edit.add(ecolor); 
		edit.addSeparator();
		edit.add(esize);
		
		
		file.add(fnew);
		file.addSeparator();
		file.add(fopen);
		file.add(fsave);
		file.add(fsaves);
		file.addSeparator();
		file.add(fexit);
		
		setLayout(new BorderLayout(1,2));
		
		add("Center", new TextArea());
		add("North", new Label("Today hard Study",Label.CENTER));
		Panel p = new Panel();
		p.add(bt1);
		p.add(bt2);
		
		add("South", p);
		
		WinEvent w = new WinEvent();
		pack();
		setSize(300, 200);
		setVisible(true);
		addWindowListener(w);
	}

	public static void main(String[] args) {

		new MenuEx();

	}

}
