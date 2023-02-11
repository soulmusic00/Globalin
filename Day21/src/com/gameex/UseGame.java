package com.gameex;

public class UseGame {
	
	public static void showMessage(Unit unit) {
		unit.message();
	}

	public static void main(String[] args) {
		
		showMessage(new Marine());
		showMessage(new SiegeTank());
		
		Unit[] rr = new Unit[3];
		rr[0] = new Marine();
		rr[1] = new SiegeTank();
		rr[2] = new DropShip();
		
		for(int i = 0; i < rr.length; i++) {
			System.out.println("---------------------");
			//모든 유닛은 좌표 100,200으로 이동하라 
			rr[i].move(100,200);
			rr[i].message();
			System.out.println("----------------------");
			
		}
		
		
		
	}

}
